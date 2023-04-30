package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.util.Objects;

public class DiffBuilder {
    public static List<Link> getDiff(Map<String, Object> firstMap,
                                     Map<String, Object> secondMap) {
        List<Link> result = new ArrayList<>();
        Set<String> allKeys = new TreeSet<>(firstMap.keySet());
        allKeys.addAll(secondMap.keySet());
        for (String key : allKeys) {
            if (!firstMap.containsKey(key)) {
                result.add(new Link("added", key, firstMap.get(key),
                        secondMap.get(key)));
            } else if (!secondMap.containsKey(key)) {
                result.add(new Link("deleted", key, firstMap.get(key),
                        secondMap.get(key)));
            } else if (!Objects.equals(firstMap.get(key), secondMap.get(key))) {
                result.add(new Link("changed", key, firstMap.get(key),
                        secondMap.get(key)));
            } else {
                result.add(new Link("unchanged", key, firstMap.get(key),
                        secondMap.get(key)));
            }
        }
        return result;
    }
}
