//Nueva Clase Case Literal
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Terminal;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseCharacterLiteral extends CaseLiteralAST {

  public CaseCharacterLiteral (CharacterLiteral iAST ,SourcePosition thePosition) {
      super (thePosition);
  	this.CL = iAST; 
    
  }

   public Object visit(Visitor v, Object o) {
    return v.visitCaseCharacterLiteral(this, o);
  }

  public CharacterLiteral CL;




}