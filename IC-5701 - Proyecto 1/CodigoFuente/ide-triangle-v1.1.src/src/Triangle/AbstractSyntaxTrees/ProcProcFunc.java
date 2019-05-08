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
public class ProcProcFunc extends ProcFunc {

  public ProcProcFunc (Identifier idAST, FormalParameterSequence fpsAST, Command comAST,
                         SourcePosition thePosition) {
    super (thePosition);
    ID = idAST;
    FPS = fpsAST;
    COM = comAST;
  }

  @Override
  public Object visit(Visitor v, Object o) {
    return v.visitProcProcFunc(this, o);
  }

  public Identifier ID;
  public FormalParameterSequence FPS;
  public Command COM;
}