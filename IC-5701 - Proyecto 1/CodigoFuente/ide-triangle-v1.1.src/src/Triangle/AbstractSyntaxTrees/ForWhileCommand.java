// Nueva clse For While Command
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForWhileCommand extends Command {

  public ForWhileCommand (Declaration dAST, Expression e1AST, Expression e2AST
               ,Command cAST, SourcePosition thePosition) {
    super (thePosition);
    D = dAST;
    E1 = e1AST;
    E2 = e2AST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForWhileCommand(this, o);
  }

  public Declaration D;
  public Expression E1,E2;
  public Command C;
}
