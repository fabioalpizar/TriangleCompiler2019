// Nueva Clase Package VName
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class PackageVName extends Vname {

  public PackageVName (Identifier iAST, Vname vNameAST, SourcePosition thePosition) {
    super (thePosition);
    I = iAST;
    V = vNameAST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitPackageVName(this, o);
  }

  public Identifier I;
  public Vname V;
}