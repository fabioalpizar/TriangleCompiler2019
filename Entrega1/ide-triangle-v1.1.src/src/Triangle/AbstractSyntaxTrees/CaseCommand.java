package Triangle.AbstractSyntaxTrees;

// Nueva Clase CaseCommand


import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class CaseCommand extends AST {

  public CaseCommand (SourcePosition thePosition) {
    super (thePosition);
  }

}