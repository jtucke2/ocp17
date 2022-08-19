package C7BeyondClasses;

import java.util.ArrayList;
import java.util.List;

record RecordFoo(int foo, int bar, List<Integer> jim) {
    public RecordFoo(int foo) {
        this(foo, 3, List.of(4));
    }

    public int foo() {
        return 99;
    }
}

record Car(int numWheels, int price) {
    public Car {
        if (numWheels < 2) throw new RuntimeException("This is not a unicycle");
        if (numWheels > 10) price = price * 2;
    }
}

public class RecordFun {
    public static void main(String[] args) {
        RecordFoo recordFoo = new RecordFoo(3, 1, new ArrayList<>());
        recordFoo.bar();
        recordFoo.jim().add(4);
        System.out.println(recordFoo);

        Car car = new Car(13, 1000);
        int a = 3;
    }
}
