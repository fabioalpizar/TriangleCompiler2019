/*
 * Funcion nueva
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialPackageDeclaration  extends Declaration {

  public SequentialPackageDeclaration  (PackageDeclaration p1AST, PackageDeclaration p2AST, SourcePosition thePosition) {
    super (thePosition);
    P1 = p1AST;
    P2 = p2AST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitSequentialPackageDeclaration (this, o);	// Falta
  }

  public PackageDeclaration P1, P2;
}