package dave.rulesengine;

public interface Condition {
    boolean eval(EvalContext ctx);
}
