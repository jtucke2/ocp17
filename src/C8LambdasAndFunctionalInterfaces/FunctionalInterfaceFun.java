package C8LambdasAndFunctionalInterfaces;

@FunctionalInterface
interface IsBird {
    // Single abstract method (SAM)
    boolean canFly(final Object o);

    // These special cases don't count towards SAM...
    String toString();
    int hashCode();
    boolean equals(Object o);
}

class Eagle implements IsBird {
    // ... Because they don't have to be implemented, as all Objects
    // have those methods.
    @Override
    public boolean canFly(Object o) {
        return false;
    }
}

public class FunctionalInterfaceFun {
    public static void main(String[] args) {

    }
}
