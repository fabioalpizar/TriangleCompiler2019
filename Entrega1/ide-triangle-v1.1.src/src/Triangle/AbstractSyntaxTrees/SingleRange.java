//Nueva Clase Single Range
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SingleRange extends CaseRange {

  public SingleRange (CaseLiteral c1AST, SourcePosition thePosition) {
    super (thePosition);
    C1 = c1AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitSingleRange(this, o);
  }

  public CaseLiteral C1;
}