//Nueva Clase Sequential Range
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialRange extends CaseRange {

  public SequentialRange (CaseRange r1AST, CaseRange r2AST, SourcePosition thePosition) {
    super (thePosition);
    R1 = r1AST;
    R2 = r2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitSequentialRange(this, o);
  }

  public CaseRange R1, R2;
}