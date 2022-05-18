%%
%int
%%
"/*"([^*]["*"]|"*"+[^/*])*"*"+"/"   {j0.comment();}
"//".*\r?\n                         {j0.comment();}
[ \t\r\f ]+                         {j0.whitespace();}
\n                                  {j0.newline();}
"break"                             { return j0.scan(edk.jzero.ParserTokens.BREAK);}
"double"                            { return j0.scan(Parser.DOUBLE);}
"else"                              { return j0.scan(Parser.ELSE);}
"boolit"                            { return j0.scan(Parser.BOOLLIT);}
"for"                               { return j0.scan(Parser.FOR);}
"if"                                { return j0.scan(Parser.IF);}
"int"                               { return j0.scan(Parser.INT);}
"null"                              { return j0.scan(Parser.NULLVAL);}
"return"                            { return j0.scan(Parser.RETURN);}
"string"                            { return j0.scan(Parser.STRING);}
"true"                              { return j0.scan(Parser.BOOLLIT);}
"bool"                              { return j0.scan(Parser.BOOL);}
"void"                              { return j0.scan(Parser.VOID);}
"while"                             { return j0.scan(Parser.WHILE);}
"class"                             { return j0.scan(Parser.CLASS);}
"static"                            { return j0.scan(Parser.STATIC);}
"public"                            { return j0.scan(Parser.PUBLIC);}
"("                                 { return j0.scan(j0.ord("("));}
")"                                 { return j0.scan(j0.ord(")"));}
"["                                 { return j0.scan(j0.ord("["));}
"]"                                 { return j0.scan(j0.ord("]"));}
"{"                                 { return j0.scan(j0.ord("{"));}
"}"                                 { return j0.scan(j0.ord("}"));}
";"                                 { return j0.scan(j0.ord(";"));}
":"                                 { return j0.scan(j0.ord(":"));}
"!"                                 { return j0.scan(j0.ord("!"));}
"*"                                 { return j0.scan(j0.ord("*"));}
"/"                                 { return j0.scan(j0.ord("/"));}
"%"                                 { return j0.scan(j0.ord("%"));}
"+"                                 { return j0.scan(j0.ord("+"));}
"-"                                 { return j0.scan(j0.ord("-"));}
"<"                                 { return j0.scan(j0.ord("<"));}
"<="                                { return j0.scan(Parser.LESSTHANOREQUAL);}
">"                                 { return j0.scan(j0.ord(">"));}
">="                                { return j0.scan(Parser.GREATERTHANOREQUAL);}
"=="                                { return j0.scan(Parser.ISEQUALTO);}
"!="                                { return j0.scan(Parser.NOTEQUALTO);}
"&&"                                { return j0.scan(Parser.LOGICALAND);}
"||"                                { return j0.scan(Parser.LOGICALOR);}
"="                                 { return j0.scan(j0.ord("=")); }
"+="                                { return j0.scan(Parser.INCREMENT); }
"-="                                { return j0.scan(Parser.DECREMENT); }
","                                 { return j0.scan(j0.ord(",")); }
"."                                 { return j0.scan(j0.ord(".")); }
[a-zA-Z_][a-zA-Z0-9_]*              { return j0.scan(Parser.IDENTIFIER); }
[0-9]+                              { return j0.scan(Parser.INTLIT); }
[0-9]*"."[0-9]*([eE][+-]?[0-9]+)?   { return j0.scan(Parser.DOUBLELIT); }
([0-9]+)([eE][+-]?([0-9]+))         { return j0.scan(Parser.DOUBLELIT); }
\"[^\"]*\"                          { return j0.scan(Parser.STRINGLIT); }
.                                   { j0.lexErr("unrecognized character"); }
