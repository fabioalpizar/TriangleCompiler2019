//Nueva Clase Else Case
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ElseCase extends CaseCommand {

  public ElseCase (Command c2AST, SourcePosition thePosition) {
    super (thePosition);
    C = c2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitElseCase(this, o);
  }

  public Command C;
}