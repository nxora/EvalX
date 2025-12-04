package dave.rulesengine;

import java.util.List;
import java.util.Map;

public class ActionCall {
    public final String name;
    public final List<Object> args;

    public ActionCall(String name, List<Object> args) {
        this.name = name;
        this.args = args;
    }
}
