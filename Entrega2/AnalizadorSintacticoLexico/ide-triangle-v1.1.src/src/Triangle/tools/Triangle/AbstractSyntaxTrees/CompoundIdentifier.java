/*
 * @(#)Identifier.java                        2.1 2003/10/07
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

// Used to represent the identifier and package identifier in a compound declaration.

package Triangle.tools.Triangle.AbstractSyntaxTrees;
import Triangle.tools.Triangle.SyntacticAnalyzer.SourcePosition;


public class CompoundIdentifier extends AST {
    public PackageIdentifier packageIdentifier;
    public Identifier identifier; // Either a Declaration or a FieldTypeDenoter

  public CompoundIdentifier ( Identifier idAST,PackageIdentifier piAST,SourcePosition thePosition) {
    super (thePosition);
    packageIdentifier = piAST;
    identifier = idAST;
    
  }

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
