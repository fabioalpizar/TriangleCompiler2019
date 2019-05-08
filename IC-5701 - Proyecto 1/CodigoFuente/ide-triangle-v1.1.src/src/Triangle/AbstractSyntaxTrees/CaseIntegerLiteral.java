//Nueva Clase Case Literal
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Terminal;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseIntegerLiteral extends CaseLiteralAST {

  public CaseIntegerLiteral (IntegerLiteral iAST ,SourcePosition thePosition) {
      super (thePosition);
  	this.IL = iAST; 
    
  }

   public Object visit(Visitor v, Object o) {
    return v.visitCaseIntegerLiteral(this, o);
  }

  public IntegerLiteral IL;




}