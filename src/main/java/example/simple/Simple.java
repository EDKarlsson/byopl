package example.simple;
import java.io.FileReader;

public class Simple {
    static Yylex lex;
    public static void main(String[] argv) throws Exception {
        // Create a file reader and attaches it to Yylex, lexical analyzer
        lex = new Yylex(new FileReader((argv[0])));
        int i;
        // yylex reads until it sees YYEOF
        while ((i = lex.yylex()) != Yylex.YYEOF)
            // yytext returns a Yytoken type
            System.out.println("token " + i + ": "+ yytext());
    }

    /**
     * This is here so that other functions in the simple class can access
     * the most recent lexeme string without having a reference to the simple
     * class Yylex object.
     * @return String
     */
    public static String yytext() {
        return lex.yytext();
    }

    public static void lexErr(String s) {
        System.out.println(s + ": " + yytext());
        System.exit(1);
    }
}
