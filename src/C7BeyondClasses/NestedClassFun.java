package C7BeyondClasses;

public class NestedClassFun {
    private int num = 1;
    class NonStaticFoo {
        private int num = 2;
        class NonStaticBar {
            private int num = 3;
            int getSum() {
                return NestedClassFun.this.num + // 1
                        NonStaticFoo.this.num + // 2
                        this.num; // 3
            }
        }
    }

    static class StaticFoo {
        static class StaticBar {
            private int num = 3;
        }
    }

    int localClassTest() {
        int methodNum = 3;
        interface hasNum {
            int getNum();
        }
        abstract class localBase implements hasNum {
            private int num = 4;
            @Override
            public int getNum() {
                return num;
            }
        }
        class localInt extends localBase {
            private int num = 7;
            @Override
            public int getNum() {
                return NestedClassFun.this.num + // 1
                        methodNum +             // 4
                        super.getNum() +        // 4
                        this.num;               // 7
            }
        }
        return new localInt().getNum();
    }

    public static void main(String[] args) {
        StaticFoo.StaticBar staticBar = new StaticFoo.StaticBar();
        int barNum = staticBar.num; // 3
        NonStaticFoo.NonStaticBar bar =  new NestedClassFun().new NonStaticFoo().new NonStaticBar();
        System.out.println(bar.getSum());
        System.out.println(new NestedClassFun().localClassTest());

        NestedClassFun nestedClassFun = new NestedClassFun() {
            @Override
            int localClassTest() {
                return 3;
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {}
        };

        Runnable runnable1 = () -> {};
        Runnable staticBar1 = (Runnable) new NestedClassFun();
    }
}
