//Nueva Clase For Command
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForCommand extends Command {

  public ForCommand (Declaration dAST, Expression eAST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    D = dAST;
    E = eAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitForCommand(this, o);
  }

  public Declaration D;
  public Expression E;
  public Command C;
}
