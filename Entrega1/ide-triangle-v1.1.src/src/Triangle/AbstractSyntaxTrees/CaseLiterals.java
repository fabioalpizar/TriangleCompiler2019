//Nueva Clase Case Literals
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseLiterals extends CaseLiteralAST {

  public CaseLiterals (CaseRange cRangeAST, SourcePosition thePosition) {
    super (thePosition);
    CRange = cRangeAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCaseLiterals(this, o);
  }

  public CaseRange CRange;
}