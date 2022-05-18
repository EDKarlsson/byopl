%{
import static ch4.lexer.yylex;
import static ch4.yyerror.yyerror;
%}
%token NAME NUMBER
%%
sequence : pair sequence | ;
pair : NAME NUMBER ;