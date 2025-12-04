package dave.rulesengine;

public class ActionResult {
    private String actionName;
    private Object result;

    public ActionResult(String actionName, Object result) {
        this.actionName = actionName;
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public String getActionName() {
        return actionName;
    }

    public static ActionResult error(String message) {
        return new ActionResult("ERROR", message);
    }

}
