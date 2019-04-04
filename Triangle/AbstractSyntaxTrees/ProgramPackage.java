// Nueva Clase ProgramPackage


package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ProgramPackage extends AST {

  public ProgramPackage (PackageDeclaration pAST, Command cAST, SourcePosition thePosition) {
    super (thePosition);
    P = pAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitProgram(this, o);
  }

  public PackageDeclaration P;
  public Command C;
}