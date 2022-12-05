package C11ExceptionsAndLocalization;

import javax.imageio.IIOException;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionFun {
    public int doubleMe(int a) {
        return a * 2;
    }

    static void foo () throws MyException, MyException2 {
        System.out.println("foop");
    }

    static class MyException extends Exception {
        public MyException(String message) {
            super(message);
        }
    }
    static class MyException2 extends RuntimeException {
        public MyException2(String message) {
            super(message);
        }
    }

    static int tryFinallyFun() {
try { return 3;
} finally { return 7; } // 7 is returned!
    }

    static void b() throws IOException {
        throw new FileNotFoundException("bob");
    }

    static class B implements Closeable {
        @Override
        public void close() throws IOException {

        }
    }

    static class C implements AutoCloseable {
        @Override
        public void close() throws Exception {

        }
    }

    public static void main(String[] args) throws IOException {
        try {
            foo();
        } catch (MyException | MyException2 e) {
            System.out.println(e.getLocalizedMessage());
        }

        try (B b = new B()) {

        }

        System.out.println(tryFinallyFun());
    }
}
