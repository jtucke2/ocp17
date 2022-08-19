package C5Methods.nested;

import C5Methods.Bird;

public class Goose extends Bird {
    void test() {
        Goose g = new Goose();
        System.out.println(g.canFly);
        Bird b = new Goose();
        // Does not work if Bird is in a different package
        // Works if bird is in the same package
//        System.out.println(b.canFly);
    }
}