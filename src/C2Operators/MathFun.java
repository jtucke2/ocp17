package C2Operators;

public class MathFun {
    public static void main(String[] args) {
        // w promoted to float, w * x = float, float / double = double
        short w = 14;
        float x = 13;
        double y = 30;
        double result = w * x / y;

        // Compound assignment can circumvent some issues with type promotion
        long goat = 10;
        int sheep = 5;
        // compiler error if you try it this way
//        sheep = sheep * goat;
        sheep *= goat; // 50

        Boolean f = false;
        Boolean n = null;
        // Throws a runtime exception, as the n is still evaluated
//        boolean bLogical = f & n;
        // false
        boolean bCond = f && n;
        int a = 3;
    }
}
