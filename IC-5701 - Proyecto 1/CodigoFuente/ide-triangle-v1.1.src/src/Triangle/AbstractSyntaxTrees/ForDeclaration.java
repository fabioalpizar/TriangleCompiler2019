/*
 * Funcion nueva
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ForDeclaration extends Declaration {

  public ForDeclaration (Identifier iAST, Expression eAST, SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    E = eAST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitForDeclaration(this, o);	// Falta
  }

  public Identifier I;
  public Expression E;
}