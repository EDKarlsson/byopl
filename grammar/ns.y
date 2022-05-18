%{
import static example.lexer.yylex;
import static example.yyerror.yyerror;
%}
%token NAME NUMBER
%%
sequence : pair sequence | ;
pair : NAME NUMBER ;