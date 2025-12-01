package dave.rulesengine;

import java.util.List;

public interface ActionHandler {
    ActionResult execute(EvalContext ctx, List<Object> args);



}
