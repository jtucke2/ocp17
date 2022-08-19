package C11ExceptionsAndLocalization;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class ExceptionFun {
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

    public static void main(String[] args) {
        try {
            foo();
        } catch (MyException | MyException2 e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println(tryFinallyFun());
    }
}
