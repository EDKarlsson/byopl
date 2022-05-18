package example;

public class Yyerror {
    public static void yyerror(String s) {
        System.err.println(s);
        System.exit(1);
    }
}
