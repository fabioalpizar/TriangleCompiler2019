/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author Gabriel
 */

public class LongIdentifier extends Identifier {

  public LongIdentifier (PackageId piAST, Identifier idAST, SourcePosition thePosition) {
    super (piAST.spelling + "$" + idAST.spelling, thePosition);
    pid = piAST;
    id = idAST;
  }
  
    public LongIdentifier (Identifier idAST,SourcePosition thePosition) {
    super ( idAST.spelling, thePosition);
    id = idAST;
  }

  public PackageId pid;
  public Identifier id; // Either a Declaration or a FieldTypeDenoter

  @Override
  public Object visit (Visitor v, Object o) {
    return v.visitLongIdentifier(this, o);
  }

}
