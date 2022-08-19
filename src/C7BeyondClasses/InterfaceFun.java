package C7BeyondClasses;

public class InterfaceFun {
interface Foo {
    default Number work() { return foo() + 3; }
    private int foo() {
        return 5;
    }
}
interface Bar {
    default Integer work() { return 4; }
}
class FuBar implements Foo, Bar {
    @Override // This works due to the override
    public Integer work() { return Bar.super.work(); }
}

    public static void main(String[] args) {
        var module = 3;

    }
}


