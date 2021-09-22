lexer grammar TopologyLexerRules;

// 操作数类别
TASKID : [0-9]+;
WS : [ \t\r\n] -> skip;

// Logical
AND : '&&' ;
OR : '||' ;
NOT : '!' ;
