package C6ClassDesign;

public abstract class AbsClassFun {
    abstract int foo();
    public static void main(String... args) {
        // The book claims this doesn't work, but it seems to
        AbsClassFun base = new Sub();
        System.out.println(base.foo());
    }
}

class Sub extends AbsClassFun {
    @Override
    int foo() {
        return 1;
    }
}
