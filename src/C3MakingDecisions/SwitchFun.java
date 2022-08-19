package C3MakingDecisions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SwitchFun {
    enum foo {foo, bar}
    public static void main(String[] args) {
        combineCases(1);

        long l = 3L;
        // Does not compile - cannot switch on long, float, double, or boolean
//        switch (l) {
//            case 3L:
//                System.out.println("pfft, you wish");
//        }

        final int someFinalInt = someFinalFn();
//        switch (1) {
//            case someFinalInt -> System.out.println("bob");
//        }

        boolean b = true;

        System.out.println(switchExpressionValue(4));


    }
    static void combineCases(int myNum) {
        switch (myNum) {
            // Java 14 combine statements
            case 1,2:
                System.out.println("you combined cases!");
//                break;
            default:
            case 3:
                System.out.println("Another statement!");
                break;
        }

    }

    static final int someFinalFn() {
        return 3;
    }

    static String switchExpressionValue(int myNum) {
        return switch (myNum) {
            default -> "jim";
            case 1 -> "bob";
            case 2, 3 -> {
                yield "foo";
            }
        };
    }
}
