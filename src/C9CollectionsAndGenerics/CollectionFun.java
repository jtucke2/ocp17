package C9CollectionsAndGenerics;

import java.util.*;

public class CollectionFun {
    static class PoorlyImplementedMethods implements Comparable {
        public int num;

        public PoorlyImplementedMethods(int num) {
            this.num = num;
        }

        @Override
        public boolean equals(Object o) {
            // The commented out will insert both into HashSet and HashMap, even with a bogus hashCode
//            return this.num == ((PoorlyImplementedMethods) o).num;
            return true;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public int compareTo(Object o) {
            // The commented out insert both the TreeSet
//            return this.num - ((PoorlyImplementedMethods) o).num;
            return 0;
        }

        @Override
        public String toString() {
            return "PIM{" +
                    "num=" + num +
                    '}';
        }
    }
    public static void main(String[] args) {
        PoorlyImplementedMethods pim3 = new PoorlyImplementedMethods(3);
        PoorlyImplementedMethods pim4 = new PoorlyImplementedMethods(4);

        Set<PoorlyImplementedMethods> poorlyImplementedMethodsTS = new TreeSet<>();
        // Requires properly implemented compareTo to insert both
        poorlyImplementedMethodsTS.add(pim3);
        poorlyImplementedMethodsTS.add(pim4);
        System.out.println(poorlyImplementedMethodsTS);

        Set<PoorlyImplementedMethods> poorlyImplementedMethodsHS = new HashSet<>();
        // Requires properly implemented hashCode OR equals to insert both
        poorlyImplementedMethodsHS.add(pim3);
        poorlyImplementedMethodsHS.add(pim4);
        System.out.println(poorlyImplementedMethodsHS);

        Map<PoorlyImplementedMethods, PoorlyImplementedMethods> map = new HashMap<>();
        // Requires properly implemented equals to insert both
        map.putIfAbsent(pim3, pim3);
        map.putIfAbsent(pim4, pim4);
        System.out.println(map);
    }
}
