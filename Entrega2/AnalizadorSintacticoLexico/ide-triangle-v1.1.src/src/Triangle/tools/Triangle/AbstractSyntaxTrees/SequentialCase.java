
//Used to represent two cases when they are in the same expression

package Triangle.tools.Triangle.AbstractSyntaxTrees;

import Triangle.tools.Triangle.SyntacticAnalyzer.SourcePosition;

public class SequentialCase extends Case {

  public SequentialCase (Case c1AST, Case c2AST, SourcePosition thePosition) {
    super (thePosition);
    C1 = c1AST;
    C2 = c2AST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitSequentialCase(this, o);
  }

  public Case C1, C2;
}