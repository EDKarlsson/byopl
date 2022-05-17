package example.simple;

import java.io.FileReader;

public class Simple2 {
    static Yylex lex;
    public static int yylineno;
    public static Token yylval;

    public static void main(String[] argv) throws Exception {
        // Create a file reader and attaches it to Yylex, lexical analyzer
        lex = new Yylex(new FileReader((argv[0])));
        yylineno = 1;
        int i;
        // yylex reads until it sees YYEOF
        while ((i = lex.yylex()) != Yylex.YYEOF)
            // yytext returns a Yytoken type
            System.out.println("token " + i +
                    " (line " + yylval.lineno + "): " + yytext());
    }

    /**
     * This is here so that other functions in the simple class can access
     * the most recent lexeme string without having a reference to the simple
     * class Yylex object.
     *
     * @return String
     */
    public static String yytext() {
        return lex.yytext();
    }

    public static void lexErr(String s) {
        System.out.println(s + ": line " + yylineno + ": " + yytext());
        System.exit(1);
    }

    public static int scan(int cat) {
        yylval = new Token(cat, yytext(), yylineno);
        return cat;
    }

    public static void increment_lineno() {
        yylineno++;
    }
}
