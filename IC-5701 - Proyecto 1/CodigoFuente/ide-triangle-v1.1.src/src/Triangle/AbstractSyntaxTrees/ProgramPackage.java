// Nueva Clase ProgramPackage


package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class ProgramPackage extends Program {

  public ProgramPackage (PackageDeclaration pAST, Command cAST, SourcePosition thePosition) {
    super (cAST, thePosition);
    P = pAST;
    C = cAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitProgramPackage(this, o);
  }

  public PackageDeclaration P;
  public Command C;
}