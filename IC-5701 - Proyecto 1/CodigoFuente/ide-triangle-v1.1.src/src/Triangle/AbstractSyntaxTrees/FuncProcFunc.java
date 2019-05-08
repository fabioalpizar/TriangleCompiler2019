/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.AbstractSyntaxTrees.Expression;
import Triangle.AbstractSyntaxTrees.FormalParameterSequence;
import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.ProcFunc;
import Triangle.AbstractSyntaxTrees.TypeDenoter;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.SyntacticAnalyzer.SourcePosition;


public class FuncProcFunc extends ProcFunc {

  public FuncProcFunc (Identifier idAST, FormalParameterSequence fpsAST, TypeDenoter tdAST, Expression eAST, 
                         SourcePosition thePosition) {
    super (thePosition);
    ID = idAST;
    FPS = fpsAST;
    TD = tdAST;
    EXP = eAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitFuncProcFunc(this, o);
  }

  public Identifier ID;
  public FormalParameterSequence FPS;
  public TypeDenoter TD;
  public Expression EXP;

}

