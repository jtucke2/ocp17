package C3MakingDecisions;

public class IfFun {
    public static void main(String[] args) {
        Object bob = "bob";
        // Java 16 pattern matching
        // Does not compile, Object is not subtype
//        if (bob instanceof Object patternMatchVar) {
//            System.out.println(patternMatchVar);
//        }
        if (bob instanceof String patternMatchVar && patternMatchVar.equals("jim")) {
            System.out.println(patternMatchVar);
        }
    }
}
