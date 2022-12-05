package C14IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileAndPathFun {
    public static void main(String[] args) throws IOException {
        processFileOrDirectory("src", "C14IO");
        processFileOrDirectory("src", "C14IO", "bob.txt");
        processFileOrDirectory("doesnotexists");


        resolveAndRelativePathDemo();
    }

    public static void processFileOrDirectory(String... segments) throws IOException {
        Path path = Path.of(".", segments);
        if (Files.exists(path)) {
            if (Files.isRegularFile(path)) {
                System.out.println(path + " was last modified on "  + Files.getLastModifiedTime(path));
            } else {
                try (Stream<Path> dirStream = Files.list(path)) {
                    List<Path> pathsInDir = dirStream
                            .map(Path::getFileName)
                            .toList();
                    System.out.println("Files in " + path + " Directory: " + pathsInDir);
                }

            }
        } else {
            System.out.println(path + " does not exist");
        }
    }

    public static void resolveAndRelativePathDemo() {
        Path barDir = Path.of("x", "y", "z", "bar");
        Path fooTxt = Path.of("foo.txt");

        Path resolve = barDir.resolve(fooTxt);
        // x\y\z\bar\foo.txt
        System.out.println(resolve);

        Path relativize = barDir.relativize(fooTxt);
        // ..\..\..\..\foo.txt
        System.out.println(relativize);
    }
}
