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
public class SequentialCaseRange extends CaseRange {

    public SequentialCaseRange(CaseRange cr1AST, CaseRange cr2AST, SourcePosition thePosition) {
        super(thePosition);
        CR1 = cr1AST;
        CR2 = cr2AST;
        
    }

    @Override
    public Object visit(Visitor v, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    CaseRange CR1;
    CaseRange CR2;
    
}
