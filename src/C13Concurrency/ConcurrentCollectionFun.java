package C13Concurrency;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionFun {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> integers = new ConcurrentHashMap<>();
        integers.put(1, 1);
        integers.put(2, 2);
        integers.put(3, 3);
        integers.put(4, 4);
        integers.keySet().forEach((i) -> integers.remove(i));

    }
}
