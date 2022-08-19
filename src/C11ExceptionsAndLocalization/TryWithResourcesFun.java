package C11ExceptionsAndLocalization;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TryWithResourcesFun {
    static class TryWithResourceFoo implements AutoCloseable {
        int bar() {
            return 3;
        }
        @Override
        public void close() throws RuntimeException {
            System.out.println("closing twr foo!");
            throw new RuntimeException("bb close");
        }
    }

    public static void main(String[] args) {
        final var foo = new TryWithResourceFoo();
        try (foo) {
            System.out.println(foo.bar());
            throw new Exception("bpb");
        } catch (RuntimeException e) {
            System.out.println(e.getLocalizedMessage());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        } finally {
            System.out.println("finallt!");
        }
    }
}
