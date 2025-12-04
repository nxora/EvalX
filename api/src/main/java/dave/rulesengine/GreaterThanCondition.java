package dave.rulesengine;

import java.util.HashMap;
import java.util.Map;

public class GreaterThanCondition implements Condition{
   private final String factKey;
   private final Comparable threshold;

    public GreaterThanCondition(String factKey, Comparable threshold) {
        this.factKey = factKey;
        this.threshold = threshold;
    }

    public boolean eval(EvalContext ctx){
        Object value = ctx.get(factKey);
        if (value == null) return false;
        if (!(value instanceof Comparable)) return false;

        Comparable comparable = (Comparable) value;//im new to this syntax
        return comparable.compareTo(threshold) >= 0;
        ActionHandler actionHandler = (ctx, actionHandler1) ->{
            System.out.println("");
        }
    }
}


//public class Main {
//    public static void main(String[] args) {
//        // 1️⃣ Build facts
//        Map<String, Object> data = Map.of("user.age", 20);
//        Facts facts = new Facts(data);
//
//        // 2️⃣ Build condition
//        Condition condition = ctx -> (Integer) ctx.get("user.age") >= 18;
//
//        // 3️⃣ Build action
//        ActionHandler printAction = (ctx, argsList) -> {
//            System.out.println("User is adult!");
//            return new ActionResult("print", "User is adult!");
//        };
//
//        // 4️⃣ Register action and build rule
//        ActionCall actionCall = new ActionCall("printAdult", List.of());
//        RuleMetadata meta = new RuleMetadata("isAdult", 1, 10, "default");
//        CompiledRule rule = new CompiledRule(meta, condition, List.of(actionCall));
//
//        DefaultRuleEngine engine = new DefaultRuleEngine(List.of(rule));
//        engine.registerAction("printAdult", printAction);
//
//        // 5️⃣ Evaluate
//        EvaluationResult result = engine.evaluate(facts);
//        System.out.println(result);
//    }
//}
