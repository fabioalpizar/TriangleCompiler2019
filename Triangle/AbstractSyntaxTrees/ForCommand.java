//Nueva Clase For Command
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForCommand extends Command {

  public ForCommand (Identifier iAST, Expression eAST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    D = iAST;
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
