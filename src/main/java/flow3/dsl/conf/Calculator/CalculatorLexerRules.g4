lexer grammar CalculatorLexerRules;

// 操作数类别
NUMBER: INT|FLOAT;
VAR : [a-zA-Z][a-zA-Z0-9]*;
INT : [0-9]+;
FLOAT : [0-9]+'.'[0-9]+;
NEWLINE: '\r'? '\n'? ;
WS : [ \t]+ -> skip;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

// Compare
GT : '>' ;
GTE : '>=' ;
LT : '<' ;
LTE : '<=' ;
EQ : '==' ;
NEQ : '!=' ;

// Logical
AND : '&&' ;
OR : '||' ;
