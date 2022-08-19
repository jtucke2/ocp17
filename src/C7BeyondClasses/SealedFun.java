package C7BeyondClasses;

sealed class SealedFun permits SealedBar {
    class F{}
    public void huh() {
        System.out.println("huh im sealed");
    }

    public static void main(String[] args) {
        System.out.println("HI!");
    }
}

non-sealed class SealedBar extends SealedFun {}



//public class SealedFun {
////    public static void main(String[] args) {
////        SealedFoo f = new SealedBar();
////        f.huh();
////    }
//}
