package C14IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesFun {
    public static Path basePath = Path.of("C14FilesPlayground");

    public static void main(String[] args) {
//        manipulateDirs();
        streamRead();
    }

    public static void manipulateDirs() {
        Path fooPath = basePath.resolve(Path.of("foo"));
        try {
            Files.createDirectory(fooPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(fooPath + " exists? " + Files.exists(fooPath));
        Path barPath = fooPath.resolve(Path.of("bar"));
        try {
            Files.createDirectory(barPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(barPath + " exists? " + Files.exists(fooPath));
        try {
            Files.delete(barPath);
            Files.delete(fooPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(fooPath + " exists? " + Files.exists(fooPath));
        System.out.println(barPath + " exists? " + Files.exists(fooPath));
    }

    public static void streamRead() {
        try (Stream<String> lines = Files.lines(Path.of("src", "C14IO", "bob.txt"))) {
            String collect = lines
                    .map(String::toUpperCase)
                    .collect(Collectors.joining(" ~ "));
            System.out.println(collect);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
