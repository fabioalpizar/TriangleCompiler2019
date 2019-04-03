//Nueva Clase Else Case
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ElseCase extends Case {

  public ElseCase (Case c1AST, Command c2AST, SourcePosition thePosition) {
    super (thePosition);
    C1 = c1AST;
    C2 = c2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitElseCase(this, o);
  }

  public Case C1;
  public Command C2;
}