package edk.jzero;

import java.io.FileReader;

public class j0 {
    static Yylex lex;

    public static Parser par;

    public static int yylineno, yycolno;
//    public static Token yylval, last_token;

    public void run(String filename) throws Exception {
        lex = new Yylex(new FileReader(filename));
        par = new Parser();
        yylineno = yycolno = 1;
        count = 0;
        int i = par.yyparse();
        
    }

    public static void main(String[] argv) throws Exception {
        lex = new Yylex(new FileReader(argv[0]));
        yylineno = yycolno = 1;
        int i;
        while ((i = lex.yylex()) != Yylex.YYEOF) {
            System.out.println("token " + i + ": " + yytext());
        }
    }

    public static String yytext() {
        return lex.yytext();
    }

    public static void lexErr(String s) {
        System.out.println(s + ": line " + yylineno +
                ": " + yytext());
        System.exit(1);
    }

    public static int scan(int cat) {
        last_token = yylval = new Token(cat, yytext(), yylineno, yycolno);
        yycolno += yytext().length();
        return cat;
    }

    public static void whitespace() {
        yycolno += yytext().length();
    }

    public static short ord(String s) {
        return (short) (s.charAt(0));
    }

    public static boolean newline() {
        yylineno++;
        yycolno = 1;
        if (last_token != null) {
            switch (last_token.cat) {
                case Parser.IDENTIFIER:
                case Parser.INTLIT:
                case Parser.DOUBLELIT:
                case Parser.STRINGLIT:
                case Parser.BREAK:
                case Parser.RETURN:
                case Parser.INCREMENT:
                case Parser.DECREMENT:
                case ')':
                case ']':
                case '}':
                    return true;
            }
        }
        return false;
    }

    public static void comment() {
        int i, len;
        String s = yytext();
        len = s.length();
        for (i = 0; i < len; i++) {
            if (s.charAt(i) == '\n') {
                yylineno++;
                yycolno = 1;
            } else {
                yycolno++;
            }
        }
    }
}
