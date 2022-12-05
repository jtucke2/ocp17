package C13Concurrency;

import java.util.function.Function;

public class ThreadFun {
    public static void main(String[] args) {
        System.out.println("Start");
        Function<String, Runnable> makeRunnable = (msg) -> () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Running with " + msg);
        };
        new Thread(makeRunnable.apply("Start")).start();
        new Thread(makeRunnable.apply("Run")).run();
        System.out.println("End");
    }
}
