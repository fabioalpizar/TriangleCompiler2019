//Nueva Clase Dual Range
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class DualRange extends CaseRange {

  public DualRange (CaseLiteral c1AST, CaseLiteral c2AST, SourcePosition thePosition) {
    super (thePosition);
    C1 = c1AST;
    C2 = c2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitDualRange(this, o);
  }

  public CaseLiteral C1, C2;
}