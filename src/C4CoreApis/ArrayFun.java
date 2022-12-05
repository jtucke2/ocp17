package C4CoreApis;

import java.util.Arrays;

public class ArrayFun {
    public static void main(String[] args) {
        // foo is int[], bar is int
        int foo[], bar;
        int[] twoD[], threeD[][];

        int asym[][] = new int[2][];
        asym[0] = new int[3];
        asym[1] = new int[6];

        Arrays.binarySearch(asym, 1);
    }
}
