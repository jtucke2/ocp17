package C6ClassDesign;

import C5Methods.Bird;

import java.util.function.Supplier;

public class C6Main {
static class foo {
    public Number getNum() { return 3; }
    public static void talk() {
        System.out.println("foo talking");
    }
}
static class bar extends foo {

    @Override
    public Integer getNum() { return 4; }

    public static void talk() {
        System.out.println("bar talking");
    }
}
    public static void main(String[] args) {
        new SubCls();
        System.out.println("Overload time");
        new SubCls(3);

        // Does not call Bird static initializer block until get is invoked
        Supplier<Bird> birdSupplier = Bird::new;

        foo b = new bar();
        b.talk();
        System.out.println(b.getNum());
    }
}
