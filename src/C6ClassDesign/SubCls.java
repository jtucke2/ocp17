package C6ClassDesign;

public class SubCls extends BaseCls {
    protected int foo = 5;

    public SubCls() {
        System.out.println("sub class cons called");
    }

    public SubCls(int foo) {
        System.out.println("Overloaded sub class cons called");
        this.foo = foo;
    }

    public static void main(String[] args) {
        SubCls subCls = new SubCls();
        System.out.println(subCls.foo);
    }
}
