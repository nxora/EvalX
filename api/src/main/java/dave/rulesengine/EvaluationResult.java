package dave.rulesengine;

import java.util.List;

public class EvaluationResult {
    private List<String> matchedRules;
    private List<ActionResult> executedActions;

    public EvaluationResult(List<String> matchedRules, List<ActionResult> executedActions) {
        this.matchedRules = matchedRules;
        this.executedActions = executedActions;
    }

    public List<String> getMatchedRules() {
        return matchedRules;
    }

    public List<ActionResult> getExecutedActions() {
        return executedActions;
    }
}
