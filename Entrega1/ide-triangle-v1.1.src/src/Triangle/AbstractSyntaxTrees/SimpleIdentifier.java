//Nueva Clase PackageIdentifier
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class SimpleIdentifier extends LongIdentifier {

  public SimpleIdentifier (Identifier id1AST, SourcePosition thePosition) {
    super (thePosition);
    ID = id2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitSimpleIdentifier(this, o);
  }

  public Identifier ID;
}