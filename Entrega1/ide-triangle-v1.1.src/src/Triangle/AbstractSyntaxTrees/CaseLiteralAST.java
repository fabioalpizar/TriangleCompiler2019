//Se crea Clase Long Identifier
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseLiteralAST extends AST {

  public CaseLiteralAST (SourcePosition thePosition) {
    super (thePosition);
  }

}
