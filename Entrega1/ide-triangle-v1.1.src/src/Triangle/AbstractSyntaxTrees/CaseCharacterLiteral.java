//Nueva Clase Case Literal
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Terminal;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseCharacterLiteral extends CaseLiteralAST {

  public CaseCharacterLiteral (CharacterLiteral iAST ,SourcePosition thePosition) {
  	this.CL = iAST; 
    super (thePosition);
  }

   public Object visit(Visitor v, Object o) {
    return v.visitCaseCharacterLiteral(this, o);
  }

  public CharacterLiteral CL;




}