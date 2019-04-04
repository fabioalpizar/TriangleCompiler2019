//Nueva Clase PackageIdentifier
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageIdentifier extends LongIdentifier {

  public PackageIdentifier (Identifier id1AST, Identifier id2AST, SourcePosition thePosition) {
    super (thePosition);
    PckID = id1AST;
    ID = id2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitPackageIdentifier(this, o);
  }

  public Identifier PckID, ID;
}