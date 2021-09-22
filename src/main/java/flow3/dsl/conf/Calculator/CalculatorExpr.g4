/**
 * Define a grammar called CalculatorExpr
 */
// 注意 grammer 要和文件名相同
grammar CalculatorExpr;

// 引入词法规则
import CalculatorLexerRules;

// 程序起始规则，语法分析的起点
program : stat+;

stat: define NEWLINE?            # defineStat
    | print NEWLINE?             # printStat
    | NEWLINE                    # blank
    ;

// 声明
define: VAR '=' expr ';'
    | VAR '==' expr ';'
    ;

// 计算表达式
expr: '('expr')'                    # parens
     | expr op=('*'|'/') expr       # MulDiv
     | expr op=('+'|'-') expr       # AddSub
     | expr op=('=='|'!='|'<'|'<='|'>'|'>=') expr  # Compare
     | expr op=('&&'|'||') expr     # LogicalOps
     | NUMBER                       # number
     | VAR                          # var
     ;

// 输出
print: 'print''('VAR')'';'       # printVAR
      | 'print''('expr')'';'     # printExpr
      ;
