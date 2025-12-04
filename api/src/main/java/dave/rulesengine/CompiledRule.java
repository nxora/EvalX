package dave.rulesengine;

import java.util.List;

public class CompiledRule {
    public final RuleMetadata metadata;
    public final Condition condition;
    public final List<ActionCall> actions;

    public CompiledRule(RuleMetadata metadata, Condition condition, List<ActionCall> actions) {
        this.metadata = metadata;
        this.condition = condition;
        this.actions = actions;
    }
}
