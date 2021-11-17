/**
 * Define a grammar called TopologyExpr
 */
// 注意 grammer 要和文件名相同
grammar TopologyExpr;

// 引入词法规则
import TopologyLexerRules;

// 程序起始规则，语法分析的起点
program : stat+;

stat: define NEWLINE?            # defineStat
    ;


// 声明
define: VAR op=(EQ|ASS) expr ';' ;

// 计算表达式
expr: '('expr')'                    # parens
     | expr op=('*'|'/') expr       # MulDiv
     | expr op=('+'|'-') expr       # AddSub
     | expr op=('=='|'!='|'<'|'<='|'>'|'>=') expr  # Compare
     | expr op=('&&'|'||') expr     # LogicalOps
     | VAR                          # var
     | NUMBER                       # number
     ;
