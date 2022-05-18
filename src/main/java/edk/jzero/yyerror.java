package edk.jzero;

public class yyerror {
    public static void yyerror(String s) {
        System.err.println("YYERROR: " + s);
        System.exit(1);
    }
}
