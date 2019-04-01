//Nueva Clase Case Expression
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseExpression extends Expression {

  public CaseExpression (CaseLiteral clAST, SourcePosition thePosition) {
    super (thePosition);
    CL = clAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitCaseExpression(this, o);
  }

  public CaseLiteral CL;
}