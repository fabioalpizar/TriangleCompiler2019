
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import Triangle.AbstractSyntaxTrees.Visitor;


public class ProcFuncs extends ProcFunc {

  public ProcFuncs (ProcFunc pf1AST, ProcFunc pf2AST, SourcePosition thePosition) {
    super (thePosition);
    PF1 = pf1AST;
    PF2 = pf2AST;
  }

  @Override
  public Object visit(Visitor v, Object o) {
    return v.visitProcFuncs(this, o);
  }

  public ProcFunc PF1, PF2;
}

