package edk.jzero;

public class Token {
    public int cat;
    public String text;
    public int lineno, colno, ival;
    String sval;
    double dval;

    private String deEscape(String sin) {
        StringBuilder sout = new StringBuilder();
        sin = sin.substring(1, sin.length() - 1);
        int i = 0;
        while (sin.length() > 0) {
            char c = sin.charAt(0);
            if (c == '\\') {
                sin = sin.substring(1);
                if (sin.length() < 1) {
                    j0.lexErr("malformed string literal");
                } else {
                    c = sin.charAt(0);
                    switch (c) {
                        case 't' -> sout.append("\t");
                        case 'n' -> sout.append("\n");
                        default -> j0.lexErr("unrecognized escape");
                    }
                }
            } else {
                sout.append(c);
            }
        }
        return sout.toString();
    }

    public Token(int c, String s, int ln, int col) {
        cat = c;
        text = s;
        lineno = ln;
        colno = col;
        switch (cat) {
            case Parser.INTLIT -> ival = Integer.parseInt(s);
            case Parser.DOUBLELIT -> dval = Double.parseDouble(s);
            case Parser.STRINGLIT -> sval = deEscape(s);
        }
    }
}
