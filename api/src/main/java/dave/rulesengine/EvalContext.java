package dave.rulesengine;

import java.util.HashMap;
import java.util.Map;

public class EvalContext {
    private final Facts facts;
    private final Map<String, Object> variables = new HashMap<>();

    public EvalContext(Facts facts) {
        this.facts = facts;
    }

    public Object get(String key){
        if (variables.containsKey(key)) {
            return variables.get(key);
        }
        return facts.get(key);
    }

    public void set(String key, Object value){
        variables.put(key, value);
    }
    public Facts getFacts (){
        return facts;
    }

}
