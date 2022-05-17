package example.simple;

public class Token {
    public int cat;
    public String text;
    public int lineno;

    public Token(int c, String s, int l) {
        cat = c;
        text = s;
        lineno = l;
    }
}
