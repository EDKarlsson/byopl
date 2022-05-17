%%
%int
%%
[a-zA-Z]+       { return Simple2.scan(1); }
[0-9]+          { return Simple2.scan(2); }
[ \t ]          { }
[ \r\n ]+       { Simple2.increment_lineno(); }
.               { Simple2.lexErr("unrecognized character"); }