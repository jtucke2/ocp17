package C10Streams;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFun {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        int i1 = Stream.of(1, 2).collect(
                () -> new AtomicInteger(),
                (i, j) -> i.addAndGet(j),
                (i, j) -> {
                    i.addAndGet(j.get());
                }
        ).get();
        System.out.println(i1);

        IntSummaryStatistics intSummaryStatistics = IntStream.range(500, 550).summaryStatistics();
        double average = intSummaryStatistics.getAverage();


    }
}
