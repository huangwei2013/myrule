/**
 * Define a grammar called TopologyExpr
 */
// 注意 grammer 要和文件名相同
grammar TopologyExpr;

// 引入词法规则
import TopologyLexerRules;

// 程序起始规则，语法分析的起点
program : expr;

// 计算表达式
expr:  TASKID                    # taskId
     | expr op=('&&'|'||') expr  # LogicalOpsAndOr
     | '('expr')'                # parens
     ;

