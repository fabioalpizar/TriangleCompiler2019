//Nueva Clase Case Literal
import Triangle.SyntacticAnalyzer.SourcePosition;

public class CaseLiteral extends Terminal {

  public CaseLiteral (String theSpelling, SourcePosition thePosition) {
    super (theSpelling, thePosition);
  }

  public Object visit (Visitor v, Object o) {
    return v.visitCaseLiteral(this, o);
  }

}