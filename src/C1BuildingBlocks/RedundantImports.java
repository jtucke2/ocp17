package C1BuildingBlocks;


import java.util.Random;
import java.util.Date;
import java.util.*;
import java.sql.*;

public class RedundantImports {
    { int a = 3; }
    { int a = 3; }
    static float ff;
    static String ss;
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(new Date());
        // From sql package
        System.out.println(new DriverPropertyInfo("bob", "jim"));
        var var = 3;// Does not compile
        var a = """
                aaaa
                bbbb
                "# forks = " + forks"
                \"""
                \"\"\"
                aaa""";// Does not compile, must but given a value at declaration
        var v = 1___3;
        var l = Long.valueOf("100");
        Long.parseLong("100");
        Long.max(100L, 100L);
        long b = 1000;
        int aa;
        var bin = 0b11;
        System.out.println(ff);
        System.out.println(a);
        System.out.println(ss);
    }
}
