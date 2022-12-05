package C13Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchFun {
    static int ref;
    static class SyncCaller {
        synchronized public void incrementAndPrint() {
            System.out.println(++ref);
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach((i) -> {
            // Since we are creating a new object each time,
            // and it is synchronizing on 'this', it can still create probz
            SyncCaller syncCaller = new SyncCaller();
            executorService.submit(syncCaller::incrementAndPrint);
        });
        executorService.shutdown();
    }
}
