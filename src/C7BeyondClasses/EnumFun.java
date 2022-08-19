package C7BeyondClasses;

enum AbstractTest {
    FOO {
        public boolean foo() {
            return true;
        }
    },
    BAR {
        public boolean foo() {
            return false;
        }
    };

    public abstract boolean foo();
}

enum Fun {
    // Semicolon optional
    FOO, BAR {
        public int b() {
            return 3;
        }
    }, BAZ;

    public int b() {
        return 4;
    }

    int b = 5;
}

enum DontDoThis {
    FOO("FOO"), BAR("BAR");
    private String val;
    public String valueAppendedInConstructor = "-BOB";

    DontDoThis(String val) {
        System.out.println("Dont do this cons with " + val);
        this.val = val.concat(valueAppendedInConstructor);
    }
}

public class EnumFun {
    public static void main(String[] args) {
        Fun[] values = Fun.values();
        DontDoThis foo = DontDoThis.FOO;
        System.out.println(foo);
        Fun.BAR.b();
    }
}
