//Nueva Clase Choose Command
package Triangle.AbstractSyntaxTrees;

//Nueva Clase Choose Command
import Triangle.SyntacticAnalyzer.SourcePosition;

public class ChooseCommand extends Command {

  public ChooseCommand (Expression eAST, Case cAST, 
                  SourcePosition thePosition) {
    super (thePosition);
    E = eAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitChooseCommand(this, o);
  }

  public Expression E;
  public Case C;
}