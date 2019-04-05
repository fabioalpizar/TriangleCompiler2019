//Nueva Clase Case Literal
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Terminal;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseLiteral extends AST {

  public CaseLiteral (SourcePosition thePosition) {
    super (thePosition);
  }
}