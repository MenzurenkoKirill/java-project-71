package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Set;
import java.util.Objects;

public class Distinctions {
    public static List<Link> differenceList(Map<String, Object> firstMapForDifference,
                                             Map<String, Object> secondMapForDifference) {
        List<Link> result = new ArrayList<>();
        Set<String> allKeys = new TreeSet<>(firstMapForDifference.keySet());
        allKeys.addAll(secondMapForDifference.keySet());
        for (String key : allKeys) {
            if (!firstMapForDifference.containsKey(key)) {
                result.add(new Link("added", key, secondMapForDifference.get(key),
                        firstMapForDifference.get(key)));
            } else if (!secondMapForDifference.containsKey(key)) {
                result.add(new Link("deleted", key, secondMapForDifference.get(key),
                        firstMapForDifference.get(key)));
            } else if (!Objects.equals(firstMapForDifference.get(key), secondMapForDifference.get(key))) {
                result.add(new Link("changed", key, secondMapForDifference.get(key),
                        firstMapForDifference.get(key)));
            } else {
                result.add(new Link("unchanged", key, secondMapForDifference.get(key),
                        firstMapForDifference.get(key)));
            }
        }
        return result;
    }
}
