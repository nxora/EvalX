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

            if (current instanceof Map) {
                current = ((Map<?, ?>) current).get(part);
                 return null;
            } else if (current instanceof List<?>) {
                int index;

                try{
                    index = Integer.parseInt(part);
                } catch (NumberFormatException e){
                    return null;
                }
                List<?> list = (List<?>) current;
                if (index < 0 || index >= list.size()){
                    return null;
                }
                current = list.get(index);
            }else {
                    return null;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public Map<String,Object> asMap() { return data; }
}


