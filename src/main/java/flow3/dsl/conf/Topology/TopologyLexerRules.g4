lexer grammar TopologyLexerRules;


NUMBER: INT|FLOAT;

fragment
Char  :   StartChar
        | '_'
        | DIGIT
        ;

fragment
StartChar
            :   [a-zA-Z]
            ;

fragment
DIGIT
:
    [0-9]
;

fragment
INT
:
    DIGIT+
;


//Identifier : [a-zA-Z]+[a-zA-Z0-9_]*;
fragment
Identifier
:
	StartChar Char*
;

VAR: Identifier;

FLOAT : INT'.'INT;

ASS : '=' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;


WS
:
	[ \t\r\n]+ -> channel(HIDDEN)
;

NEWLINE
:
    '\r'? '\n' ->channel(HIDDEN)
;

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
