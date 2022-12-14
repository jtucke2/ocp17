package C9CollectionsAndGenerics;

import java.util.ArrayList;
import java.util.List;

class GenFoo {
    public List<Number> foo() {
        return List.of();
    }
}

class GenBar extends GenFoo {
    @Override // Override MUST be <Number>
    public ArrayList<Number> foo() {
        return new ArrayList<>();
    }
}

interface GenBob<T> {
    void huh(T t);
}

interface GenJim<U> extends GenBob<U> {

}

//class GenCollection<U> implements Collection<U> { }

record GenRecord<T extends Number>(T myVar) {
}

class GenA {
    public void a() {}
}

class GenB extends GenA {
    public void b() {}
}

class GenC extends GenB {
    public void c() {}
}

public class GenericFun {
    public static <T> T huh(T t) {
        return t;
    }

    public static void main(String[] args) {
        // GenC extends GenB extends GenA
        // The ArrayList<> type can be GenA or GenB, but not GenC
        List<? super GenB> genList = new ArrayList<GenA>();
        // genList.add(new GenA()); -- Does not compile
        genList.add(new GenB());
        genList.add(new GenC());
        Object object = genList.get(0);
    }
}
