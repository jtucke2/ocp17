package C9CollectionsAndGenerics;

import java.util.*;

public class CollectionFun {
    static class SetMe {
        public int num;

        public SetMe(int num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }
    public static void main(String[] args) {
        Collection<Integer> col = List.of(1);
        Deque<Integer> integers = new LinkedList<>(List.of(1));

        Set<SetMe> setMes = new TreeSet<>();
        setMes.add(new SetMe(3));
        setMes.add(new SetMe(4));
        setMes.add(new SetMe(5));

        Map<Integer, Integer> m = new HashMap<>();

        int a = 3;
    }
}
