
//Used to represent the AST of the procedures and functions

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public abstract class ProcFunc extends AST {

  public ProcFunc (SourcePosition thePosition) {
    super (thePosition);
  }
}
