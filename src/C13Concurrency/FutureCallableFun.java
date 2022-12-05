package C13Concurrency;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FutureCallableFun {
    public static void main(String[] args) throws InterruptedException {
        List<Callable<String>> callables = Stream.of(1, 2, 3)
                .map(i -> makeCallable(i.toString()))
                .collect(Collectors.toList());

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("presubmit" + Instant.now());
        List<String> nums = executorService.invokeAll(callables)
                .parallelStream()
                .map(f -> {
                    try {
                        return f.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
        System.out.println(nums.toString() + Instant.now());
        executorService.shutdown();
    }

    public static Callable<String> makeCallable(String msg) {
        return () -> {
            long wait = Math.round(Math.random() * 5000);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Waited " + wait + "ms to say: " + msg  + " ~ " + Instant.now());
            return msg;
        };
    }
}
