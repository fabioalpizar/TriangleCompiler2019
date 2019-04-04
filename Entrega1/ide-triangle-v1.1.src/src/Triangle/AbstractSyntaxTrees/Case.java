//Nueva Clase Case
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class Case extends CaseCommand {

  public Case (CaseLiterals c1AST, Command c2AST, SourcePosition thePosition) {
    super (thePosition);
    C1 = c1AST;
    C2 = c2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCase(this, o);
  }

  public Command C2;
  public CaseLiterals C1;
}