package C13Concurrency;

import java.util.concurrent.*;

public class ScheduledTasks {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        singleThreadScheduleMultipleSubmissionDemo();
    }

    public static void singleThreadScheduleDemo() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<Integer> schedule = scheduledExecutorService.schedule(() -> {
            System.out.println("Pre sleep");
            Thread.sleep(1000);
            System.out.println("post sleep");
            return 3;
        }, 1, TimeUnit.SECONDS);
        System.out.println("Starting " + schedule.getDelay(TimeUnit.MILLISECONDS));
        Integer futureInt = schedule.get();
        System.out.println(futureInt);
        scheduledExecutorService.shutdown();
    }

    public static void scheduleAtFixedRateDemo() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("Pre sleep");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("post sleep");
        }, 1, 1, TimeUnit.SECONDS);
        System.out.println("Starting " + scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
        Thread.sleep(3000);
        scheduledFuture.cancel(false);
        scheduledExecutorService.shutdown();
    }

    public static void singleThreadScheduleMultipleSubmissionDemo() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Callable<Integer> callable = () -> {
            System.out.println("callable");
            return 3;
        };
        ScheduledFuture<Integer> schedule1 = scheduledExecutorService.schedule(callable, 1, TimeUnit.SECONDS);
        ScheduledFuture<Integer> schedule2 = scheduledExecutorService.schedule(callable, 1, TimeUnit.SECONDS);
        ScheduledFuture<Integer> schedule3 = scheduledExecutorService.schedule(callable, 1, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
    }
}
