package edk.jzero;

import java.io.FileReader;

public class j0 {
    static Yylex yylexer;

    public static Parser par;

    public static int yylineno, yycolno, count;
//    public static Token yylval, last_token;

    public static void main(String[] argv) throws Exception {
        init(argv[0]);
        boolean debug = argv.length > 1;
        par = new Parser(debug);
        yylineno = yycolno = 1;
        count = 0;
        int i = par.yyparse();
        if (i == 0) {
            System.out.println("no errors, " + j0.count + " tokens parsed");
        }
    }

    public static void init(String s) throws Exception {
        yylexer = new Yylex(new FileReader(s));
    }

    public static int yylex() {
        int rv = 0;
        try {
            return yylexer.yylex();
        } catch (java.io.IOException ioException) {
            rv = -1;
        }
        return rv;
    }

    public static int YYEOF() {
        return Yylex.YYEOF;
    }

    public static String yytext() {
        return yylexer.yytext();
    }

    public static void lexErr(String s) {
        System.out.println(s + ": line " + yylineno +
                ": " + yytext());
        System.exit(1);
    }

    public static int scan(int cat) {
//        last_token = yylval = new Token(cat, yytext(), yylineno, yycolno);
        par.yyval = new ParserVal(new Token(cat, yytext(), yylineno, yycolno));
        yycolno += yytext().length();
        count++;
        return cat;
    }

    public static void whitespace() {
        yycolno += yytext().length();
    }

    public static short ord(String s) {
        return (short) (s.charAt(0));
    }

    public static void newline() {
        yylineno++;
        yycolno = 1;
/*
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
*/
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
