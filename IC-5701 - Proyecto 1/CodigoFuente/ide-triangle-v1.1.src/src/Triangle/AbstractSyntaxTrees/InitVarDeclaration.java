
// Clase nueva

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class InitVarDeclaration extends Declaration {

  public InitVarDeclaration (Identifier iAST, Expression eAST, SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    E = eAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitInitVarDeclaration(this, o);
  }

  public Identifier I;
  public Expression E;
}