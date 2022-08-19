package C5Methods;


public class BoxingFun {
    public static void main(String[] args) {

    }

    void unboxing() {
        long l = Integer.valueOf(3);
        Integer i = 3;
        double d = i;
        Object o = 3;
        if (true ) {
            var name = 3;
        }
        final var name = 3;
    }

    void autoboxing() {
//        // None of these compile
//        Long l = Integer.valueOf(3);
//        Double d = 3;
//        // f is required for Float literals
//        Float f = 3.4;
    }
}
