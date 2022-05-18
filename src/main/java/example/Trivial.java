package example;

public class Trivial {
    static j0p par;
    public static void main(String[] argv) throws Exception {
        lexer.init(argv[0]);
        par = new Parser();
        int i = par.yyparse();
        if (i ==0 )
            System.out.println("no errors");
    }
}
