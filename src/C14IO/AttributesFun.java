package C14IO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class AttributesFun {
    static Path path = Path.of("src", "C14IO", "bob.txt");

    public static void main(String[] args) throws IOException {
        AttributesFun.doAtts();
    }

    public static void doAtts() throws IOException {
        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);

        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);

        DosFileAttributes dosFileAttributesFromView = fileAttributeView.readAttributes();
    }
}
