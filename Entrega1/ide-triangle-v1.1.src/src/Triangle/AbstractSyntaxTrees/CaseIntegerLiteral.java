//Nueva Clase Case Literal
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Terminal;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseIntegerLiteral extends CaseLiteralAST {

  public CaseIntegerLiteral (IntegerLiteral iAST ,SourcePosition thePosition) {
  	this.IL = iAST; 
    super (thePosition);
  }

   public Object visit(Visitor v, Object o) {
    return v.visitIntegerLiteral(this, o);
  }

  public IntegerLiteral IL;




}