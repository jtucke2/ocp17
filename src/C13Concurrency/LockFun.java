package C13Concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFun {
    public static void main(String[] args) {
        Lock a = new ReentrantLock(true);
        Lock b = new ReentrantLock(true);
        AB(a, b);
        BA(a, b);
    }

    public static void AB(Lock a, Lock b) {
        new Thread(() -> {
            a.lock();
            try {
                System.out.println("AB-a");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b.lock();
            try {
                System.out.println("AB-b");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b.unlock();
            a.unlock();
        }).start();
    }

    public static void BA(Lock a, Lock b) {
        new Thread(() -> {
            b.lock();
            try {
                System.out.println("BA-a");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a.lock();
            try {
                System.out.println("BA-b");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            b.unlock();
            a.unlock();
        }).start();
    }
}
