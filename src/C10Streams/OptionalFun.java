package C10Streams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class OptionalFun {
    public static void main(String[] args) {
        Optional.of(3)
                .map(i -> i * 3)
                .filter(i -> i == 9)
                .or(() -> Optional.of(5555))
                .ifPresent(System.out::println);

        final List<Integer> list = List.of(99);
        Optional.ofNullable(list)
                .orElse(List.of(1,2))
                .forEach(System.out::println);

var collect = Stream.of(5, 1, 4, 2, 3)
        .collect(
                Collectors.groupingBy(
                        // Determines key
                        Function.identity(),
                        // (optional) Determines the type of Map to be used
                        // Linked HashMap will keep order of keys as they are inserted
                        LinkedHashMap::new,
                        // (optional) Determines how values are placed into the map
                        Collectors.toMap(i -> i * 5, j -> j * 4)
                )
        );

        System.out.println(collect);

        var collect2 = Stream.of(5, 5, 5, 1, 4, 2, 3)
                .collect(
                        Collectors.teeing(
                                Collectors.toSet(),
                                Collectors.averagingInt(i -> i),
                                (nums, avg) -> {
                                    nums.removeIf(i -> i < avg);
                                    return nums.stream().toList();
                                })
                );

        System.out.println(collect2);

        LongStream.of(4L).filter(i -> i > 0).findFirst();
        "".isEmpty();
    }
}
