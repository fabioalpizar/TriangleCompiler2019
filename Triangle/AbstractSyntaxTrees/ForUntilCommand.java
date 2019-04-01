// Nueva clase For Until Command
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForUntilCommand extends Command {

  public ForUntilCommand (Declaration dAST, Expression e1AST, Expression e2AST
               ,Command cAST, SourcePosition thePosition) {
    super (thePosition);
    D = dAST;
    E1 = e1AST;
    E2 = e2AST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForUntilCommand(this, o);
  }

  public Declaration D;
  public Expression E1,E2;
  public Command C;
}
