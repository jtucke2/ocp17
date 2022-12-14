package C6ClassDesign;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.function.DoubleConsumer;

public abstract class AbsClassFun {
    public abstract int foo();

    public void bar() {
    }

    public static void main(String... args) {
        // The book claims this doesn't work, but it seems to
        AbsClassFun base = new Sub();
    }
}

interface AbsClassInt {
    void bar();
}

class Sub extends AbsClassFun implements AbsClassInt {
    @Override
    public int foo() {
        return 1;
    }
}
