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
//Used to represent the of the declaration of one variable when the token
//preceding it is a colon


package Triangle.tools.Triangle.AbstractSyntaxTrees;

import Triangle.tools.Triangle.SyntacticAnalyzer.SourcePosition;

public class VarSingleDeclarationColon extends VarSingleDeclaration {

  public VarSingleDeclarationColon (TypeDenoter tAST,
                         SourcePosition thePosition) {
    super (thePosition);
    T = tAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitVarSingleDeclarationColon(this, o);
  }

  public TypeDenoter T;
}
