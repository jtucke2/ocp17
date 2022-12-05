package C14IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IOStreamFun {
    static File inputFile = Path.of("src", "C14IO", "bob.txt").toFile();
    static File outputFile = Path.of("src", "C14IO", "output.txt").toFile();

    public static void main(String[] args) throws IOException {
        bufferedStreams();
    }

    public static void bufferedStreams() throws FileNotFoundException, IOException {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));) {
            List<Integer> nums = new ArrayList<>();
            // int represents bytes - bytes are not used because -1 can be returned
            int cur;
            while ((cur = bufferedInputStream.read()) != -1) {
                nums.add(cur);
            }
            String readIn = nums.stream()
                    .map(Character::toString)
                    .collect(Collectors.joining());
            System.out.println(readIn);
        }
        Files.readAllLines(Path.of(""));
        Files.readString(Path.of(""));

        try(FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inputFile));) {
                int cur;
                while ((cur = bufferedInputStream.read()) != -1) {
                    fileOutputStream.write(cur);
                    fileOutputStream.flush();
                }
            }
        }
    }

    public static void bufferedReaderWriter() {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//        bufferedReader.lines().forEach(System.out::println);
//        bufferedReader.close();
    }
}
