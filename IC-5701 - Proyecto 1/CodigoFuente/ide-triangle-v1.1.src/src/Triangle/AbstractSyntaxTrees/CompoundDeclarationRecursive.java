/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class CompoundDeclarationRecursive extends CompoundDeclaration {

  public CompoundDeclarationRecursive (ProcFunc pfAST,
                    SourcePosition thePosition) {
    super (thePosition);
    PF = pfAST;
  }

  @Override
  public Object visit(Visitor v, Object o) {
    return v.visitCompoundDeclarationRecursive(this, o);
  }

  public ProcFunc PF;
}