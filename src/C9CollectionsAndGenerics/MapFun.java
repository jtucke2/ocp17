package C9CollectionsAndGenerics;

import C11ExceptionsAndLocalization.ExceptionFun;

import java.util.HashMap;
import java.util.Map;

public class MapFun {
    public static void main(String[] args) {
        Map<String, String> carMap = new HashMap<>(Map.ofEntries(
                Map.entry("Bob", "Ford"),
                Map.entry("Jim", "Chevy")
        ));
        // remapping Fn never called for fred as his value is null
        carMap.put("Fred", null);
        System.out.println(carMap);
        carMap.keySet().forEach(k -> {
            carMap.merge(k, "honda", (v1, v2) -> !v1.equals("honda") ? "value from remapper" : "yay honda");
        });
        // remapping Fn never called as wanda is not defined
        carMap.merge("Wanda", "Toyota", (v1, v2) -> null);
        System.out.println(carMap);

        // This will remove jim as the remapper returns null
        carMap.merge("Jim", "noop", (v1, v2) -> null);
        System.out.println(carMap.getOrDefault("Jim", "Jim is empty"));
    }
}
