/*
 * @(#)VarDeclaration.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

//Used to represent the identifiar, fps, type denoter, and expression
// in a function

package Triangle.tools.Triangle.AbstractSyntaxTrees;

import Triangle.tools.Triangle.SyntacticAnalyzer.SourcePosition;

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
