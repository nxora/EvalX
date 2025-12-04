package dave.rulesengine;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultRuleEngine implements RuleEngine {

    private final List<CompiledRule> rules = new ArrayList<>();
    private final Map<String, ActionHandler> actionRegistry = new ConcurrentHashMap<>();

     public DefaultRuleEngine(List<CompiledRule> compiledRules) {
        if (compiledRules != null) {
            rules.addAll(compiledRules);
        }
    }

    @Override
    public EvaluationResult evaluate(Facts facts) {
        EvalContext ctx = new EvalContext(facts);

        List<ActionResult> actionResults = new ArrayList<>();
        List<String> matchedRules = new ArrayList<>();

        rules.sort(
                Comparator.comparingInt((CompiledRule r) -> r.metadata.getPriority())
                        .reversed()
                        .thenComparing(r -> r.metadata.getName())
        );

        for (CompiledRule rule : rules) {
            try {
                boolean conditionPassed = rule.condition.eval(ctx);

                if (conditionPassed) {
                    matchedRules.add(rule.metadata.getName());

                    for (ActionCall action : rule.actions) {
                        ActionHandler handler = actionRegistry.get(action.name);
                        if (handler == null) {
                            actionResults.add(ActionResult.error("Unknown action: " + action.name));
                            continue;
                        }

                        try {
                            ActionResult result = handler.execute(ctx, action.args);
                            actionResults.add(result);
                        } catch (Exception ex) {
                            actionResults.add(ActionResult.error(
                                    "Action failed: " + action.name + " -> " + ex.getMessage()
                            ));
                        }
                    }
                }
            } catch (Exception ex) {
                actionResults.add(ActionResult.error(
                        "Error evaluating rule " + rule.metadata.getName() + ": " + ex.getMessage()
                ));
            }
        }
        return new EvaluationResult(matchedRules, actionResults);

    }

    @Override
    public List<RuleMetadata> listActiveRules() {
        return rules.stream()
                .map(r -> r.metadata)
                .toList();
    }

    @Override
    public void reloadAll() {
        // v1: do nothing
        // v2: recompile rules from file/db
        throw new UnsupportedOperationException("Not supported yet");
    }

    @Override
    public void registerAction(String name, ActionHandler handler) {
        Objects.requireNonNull(name, "action name cannot be null");
        Objects.requireNonNull(handler, "action handler cannot be null");
        actionRegistry.put(name, handler);
    }
}
