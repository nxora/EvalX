package dave.rulesengine;

import java.util.List;
import java.util.Map;

public class Facts {
    private final Map<String, Object> data;

    public Facts(Map<String, Object> data) {
        this.data = data;
    }

    public Object get(String dottedPath) {
        if (dottedPath == null || dottedPath.isEmpty()) {
            return null;
        }

        String[] parts = dottedPath.split("\\.");
        Object current = data;
        for (String part : parts) {

            if (!(current instanceof Map<?, ?> currentMap) || !(current instanceof List<?> currentList)) {
                 return null;
            }
            if (current instanceof Map){
                current = currentMap.get(part);
            }
            if (current instanceof List){
                current = currentList.get(Integer.parseInt(part));
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public Map<String,Object> asMap() { return data; }
}


