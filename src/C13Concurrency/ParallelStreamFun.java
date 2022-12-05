package C13Concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamFun {
    public static void main(String[] args) {
        parallelCollect();
    }

    public static void parallelTask() {
        // Example 1 - doing 20 tasks delayed 200 ms takes 200 ms
        long start = System.currentTimeMillis();
        List<Integer> collect = IntStream.range(0, 20)
                .parallel()
                .mapToObj(ParallelStreamFun::doWork)
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

    public static void parallelCollect() {
        // Example 1 - doing 20 tasks delayed 200 ms takes 200 ms
        long start = System.currentTimeMillis();
        List<Object> collect = IntStream.range(0, 20)
                .parallel()
                .unordered()
                .mapToObj(ParallelStreamFun::doWork)
                .collect(ArrayList::new, List::add, List::addAll);

        System.out.println(collect);
        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

    public static Integer doWork(int input) {
        try {
            Thread.sleep(Math.round(Math.random() * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return input + 1;
    }
}
