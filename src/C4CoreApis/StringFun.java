package C4CoreApis;

import java.time.Instant;

public class StringFun {
    public static void main(String[] args) {
        String name = "jason";
        System.out.println(name.replace("as", "FOO"));

        String block = """
                bob
                    jim
                        fred
                """;

        System.out.println("---block---");
        System.out.println(block);
        System.out.println("indent 5");
        System.out.println(block.indent(5));
        System.out.println("indent -5");
        System.out.println(block.indent(-5));
        System.out.println("stripIndent");
        System.out.println(block.stripIndent());

        String formatBlock = """
                String: %s
                Int: %d
                Line Break (no arg): %n
                Float: %f
                """;
        System.out.println(
                String.format(formatBlock, "bob", 4, 5.3)
        );
        System.out.println(
                formatBlock.formatted("bob", 4, 5.3)
        );
    }
}
