package C13Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierFun {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> System.out.println("Barrier complete"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0, 10).forEach((i) -> {
            executorService.submit(() -> doStuff(cyclicBarrier));
        });
        executorService.shutdown();
    }

    public static void doStuff(CyclicBarrier cyclicBarrier) {
        System.out.println("Waiting...");
        try {
            Thread.sleep( Math.round(Math.random() * 2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("doStuff done");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Past Barrier");
    }
}
