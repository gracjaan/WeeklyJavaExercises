package ss.week4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {

    /**
     * Evaluate if the map is One on one.
     * @param map the map to be evaluated
     * @return true if for all v in the value set of the map f, there exists exactly one key k in the map’s key set
     */
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        Map<K, V> tempMap = new HashMap<>();
        for(Map.Entry<K, V> entry: map.entrySet()) {
            if (tempMap.containsKey(entry.getKey())|| tempMap.containsValue(entry.getValue())) {
                return false;
            }
            else {
                tempMap.put(entry.getKey(), entry.getValue());
            }
        }
        return true;
    }
    /**
     * Evaluate if the map is Surjective on Range
     * @param map, range to be evaluated,
     * @return true if for all v in the range, there exists a key k in the map’s key set
     */
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for (V value: range) {
            if (!map.containsValue(value)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Inverse the given map
     * @param map the map to be inversed
     * @return the map with values as keys, and  a set of values that point towards a given key
     */
    // needs to return Set because multiple values can point towards the same key
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> result = new HashMap<>();
        for (Map.Entry entry: map.entrySet()) {
            if (result.containsKey(entry.getValue())) {
                result.get(entry.getValue()).add((K) entry.getKey());
            }
            else {
                result.put((V) entry.getValue(), new HashSet<>());
                result.get(entry.getValue()).add((K) entry.getKey());
            }
        }
        return result;
    }
    /**
     * Inverse the given Bijection map
     * @param map the map to be inversed
     * @return the map with values as keys, and the keys as values
     */
    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> result = new HashMap<>();
        for (Map.Entry entry: map.entrySet()) {
            result.put((V) entry.getValue(), (K) entry.getKey());
        }
        return result;
    }
    /**
     * Check if two given arrays are compatible to be composed.
     * @param f, g  the maps whose compatibility is evaluated
     * @return the map with values as keys, and  a set of values that point towards a given key
     */
    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        for (Map.Entry entry: f.entrySet()) {
            if (!g.containsKey(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
    /**
     * Compose two given arrays
     * @param f,g the maps to be composed
     * @return a map with the Values of the first map as keys, and the values of the second map as values
     */
    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> result = new HashMap<>();
        for (Map.Entry entry1: f.entrySet()) {
            for(Map.Entry entry2: g.entrySet()) {
                if (entry1.getValue()==entry2.getKey()) {
                    result.put((K) entry1.getKey(), (W) entry2.getValue());
                }
            }
        }
        return result;
    }
	
}
