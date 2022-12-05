package C13Concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockFun {


    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock(true);
        Lock lock2 = new ReentrantLock(true);

        new Thread(() -> {
            try {
                operation1(lock1, lock2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T1").start();
        new Thread(() -> {
            try {
                operation2(lock1, lock2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "T2").start();
    }

    public static void operation1(Lock lock1, Lock lock2) throws InterruptedException {
        while (true) {
            lock1.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("lock1 acquired, trying to acquire lock2.");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lock2.tryLock()) {
                System.out.println("lock2 acquired.");
            } else {
                System.out.println("cannot acquire lock2, releasing lock1.");
                lock1.unlock();
                continue;
            }

            System.out.println("executing first operation.");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public static void operation2(Lock lock1, Lock lock2) throws InterruptedException {
        while (true) {
            lock2.tryLock(50, TimeUnit.MILLISECONDS);
            System.out.println("lock2 acquired, trying to acquire lock1.");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lock1.tryLock()) {
                System.out.println("lock1 acquired.");
            } else {
                System.out.println("cannot acquire lock1, releasing lock2.");
                lock2.unlock();
                continue;
            }

            System.out.println("executing second operation.");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
