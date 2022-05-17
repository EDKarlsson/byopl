
### Issues with book


### Mine
```java
    private String deEscape(String sin) {
        StringBuilder sout = new StringBuilder(sin);
        sin = sin.substring(1, sin.length() - 1);

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
```

### Book
```java
    private String deEscape(String sin) {
        String sout = "";
        sin = String.substring(sin, 1, sin.length() - 1);
        int i; 
        ....
            if (c == '\\') {
                sin = String.substring(sin, 1);
        ....
            } else {
                sout = sout + c;
            }
        }
        return sout;
    }
```