//Nueva Clase PackageId
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageId extends Identifier {

  public PackageId (Identifier id1AST, Identifier id2AST, SourcePosition thePosition) {
    super (id1AST.spelling, thePosition);
    PckID = id1AST;
    ID = id2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitPackageId(this, o);
  }

  public Identifier PckID, ID;
}