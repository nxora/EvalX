package dave.rulesengine;

import java.util.List;

public interface RuleEngine {
    EvaluationResult evaluate(Facts facts);
    List<RuleMetadata> listActiveRules();
    void reloadAll();
    void registerAction(String name, ActionHandler handler);
}
