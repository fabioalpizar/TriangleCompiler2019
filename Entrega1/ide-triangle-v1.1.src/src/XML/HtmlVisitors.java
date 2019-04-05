/*
 * @(#)LayoutVisitor.java                        2.1 2003/10/07
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

package XML;
import Triangle.AbstractSyntaxTrees.AnyTypeDenoter;
import Triangle.AbstractSyntaxTrees.ArrayExpression;
import Triangle.AbstractSyntaxTrees.ArrayTypeDenoter;
import Triangle.AbstractSyntaxTrees.AssignCommand;
import Triangle.AbstractSyntaxTrees.BinaryExpression;
import Triangle.AbstractSyntaxTrees.BinaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.BoolTypeDenoter;
import Triangle.AbstractSyntaxTrees.CallCommand;
import Triangle.AbstractSyntaxTrees.CallExpression;
import Triangle.AbstractSyntaxTrees.Case;
import Triangle.AbstractSyntaxTrees.CaseCharacterLiteral;
import Triangle.AbstractSyntaxTrees.CaseIntegerLiteral;
import Triangle.AbstractSyntaxTrees.CaseLiterals;
import Triangle.AbstractSyntaxTrees.CharTypeDenoter;
import Triangle.AbstractSyntaxTrees.CharacterExpression;
import Triangle.AbstractSyntaxTrees.CharacterLiteral;
import Triangle.AbstractSyntaxTrees.ChooseCommand;
import Triangle.AbstractSyntaxTrees.ConstActualParameter;
import Triangle.AbstractSyntaxTrees.ConstDeclaration;
import Triangle.AbstractSyntaxTrees.ConstFormalParameter;
import Triangle.AbstractSyntaxTrees.DoUntilCommand;
import Triangle.AbstractSyntaxTrees.DoWhileCommand;
import Triangle.AbstractSyntaxTrees.DotVname;
import Triangle.AbstractSyntaxTrees.DualRange;
import Triangle.AbstractSyntaxTrees.ElseCase;
import Triangle.AbstractSyntaxTrees.EmptyActualParameterSequence;
import Triangle.AbstractSyntaxTrees.EmptyCommand;
import Triangle.AbstractSyntaxTrees.EmptyExpression;
import Triangle.AbstractSyntaxTrees.EmptyFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.ErrorTypeDenoter;
import Triangle.AbstractSyntaxTrees.ForCommand;
import Triangle.AbstractSyntaxTrees.ForDeclaration;
import Triangle.AbstractSyntaxTrees.ForUntilCommand;
import Triangle.AbstractSyntaxTrees.ForWhileCommand;
import Triangle.AbstractSyntaxTrees.FuncActualParameter;
import Triangle.AbstractSyntaxTrees.FuncDeclaration;
import Triangle.AbstractSyntaxTrees.FuncFormalParameter;
import Triangle.AbstractSyntaxTrees.Identifier;
import Triangle.AbstractSyntaxTrees.IfCommand;
import Triangle.AbstractSyntaxTrees.IfExpression;
import Triangle.AbstractSyntaxTrees.InitVarDeclaration;
import Triangle.AbstractSyntaxTrees.IntTypeDenoter;
import Triangle.AbstractSyntaxTrees.IntegerExpression;
import Triangle.AbstractSyntaxTrees.IntegerLiteral;
import Triangle.AbstractSyntaxTrees.LetCommand;
import Triangle.AbstractSyntaxTrees.LetExpression;
import Triangle.AbstractSyntaxTrees.LongIdentifier;
import Triangle.AbstractSyntaxTrees.MultipleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleArrayAggregate;
import Triangle.AbstractSyntaxTrees.MultipleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.MultipleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.MultipleRecordAggregate;
import Triangle.AbstractSyntaxTrees.Operator;
import Triangle.AbstractSyntaxTrees.PackageDeclaration;
import Triangle.AbstractSyntaxTrees.PackageId;
import Triangle.AbstractSyntaxTrees.PackageVName;
import Triangle.AbstractSyntaxTrees.PrivateDeclaration;
import Triangle.AbstractSyntaxTrees.ProcActualParameter;
import Triangle.AbstractSyntaxTrees.ProcDeclaration;
import Triangle.AbstractSyntaxTrees.ProcFormalParameter;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.ProgramPackage;
import Triangle.AbstractSyntaxTrees.RecordExpression;
import Triangle.AbstractSyntaxTrees.RecordTypeDenoter;
import Triangle.AbstractSyntaxTrees.SequentialCase;
import Triangle.AbstractSyntaxTrees.SequentialCommand;
import Triangle.AbstractSyntaxTrees.SequentialDeclaration;
import Triangle.AbstractSyntaxTrees.SequentialPackageDeclaration;
import Triangle.AbstractSyntaxTrees.SequentialRange;
import Triangle.AbstractSyntaxTrees.SimpleIdentifier;
import Triangle.AbstractSyntaxTrees.SimpleTypeDenoter;
import Triangle.AbstractSyntaxTrees.SimpleVname;
import Triangle.AbstractSyntaxTrees.SingleActualParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleArrayAggregate;
import Triangle.AbstractSyntaxTrees.SingleFieldTypeDenoter;
import Triangle.AbstractSyntaxTrees.SingleFormalParameterSequence;
import Triangle.AbstractSyntaxTrees.SingleRange;
import Triangle.AbstractSyntaxTrees.SingleRecordAggregate;
import Triangle.AbstractSyntaxTrees.SubscriptVname;
import Triangle.AbstractSyntaxTrees.TypeDeclaration;
import Triangle.AbstractSyntaxTrees.UnaryExpression;
import Triangle.AbstractSyntaxTrees.UnaryOperatorDeclaration;
import Triangle.AbstractSyntaxTrees.UntilCommand;
import Triangle.AbstractSyntaxTrees.VarActualParameter;
import Triangle.AbstractSyntaxTrees.VarDeclaration;
import Triangle.AbstractSyntaxTrees.VarFormalParameter;
import Triangle.AbstractSyntaxTrees.Visitor;
import Triangle.AbstractSyntaxTrees.VnameExpression;
import Triangle.AbstractSyntaxTrees.WhileCommand;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlVisitors implements Visitor {

    private FileWriter fileWriter;
    private boolean SeqDeclarationFlag = false;
    private boolean SeqCommandFlag = false;
    private boolean SeqCaseFlag = false;
    private boolean SeqRangeFlag = false;

    HtmlVisitors(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    // Commands
    public Object visitAssignCommand(AssignCommand ast, Object obj) {
        writeTxtHTML("<p>");
        ast.V.visit(this, null);
        writeTxtHTML(" := ");
        ast.E.visit(this, null);
        writeTxtHTML(";</p>");
        return null;
    }

    public Object visitCallCommand(CallCommand ast, Object obj) {
        writeLineHTML("<CallCommand>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML("</CallCommand>");
        return null;
    }

    public Object visitEmptyCommand(EmptyCommand ast, Object obj) {
        writeLineHTML("<EmptyCommand/>");
        return null;
    }

    public Object visitIfCommand(IfCommand ast, Object obj) {
        writeLineHTML("<IfCommand>");
        ast.E.visit(this, null);
        ast.C1.visit(this, null);
        ast.C2.visit(this, null);
        writeLineHTML("</IfCommand>");
        return null;
    }

    public Object visitLetCommand(LetCommand ast, Object obj) {
        writeTxtHTML("<p><b>let</b></p>\n");
        ast.D.visit(this, null);
        ast.C.visit(this, null);
        return null;
    }

    public Object visitSequentialCommand(SequentialCommand ast, Object obj) {
        if(SeqCommandFlag == false){
            this.SeqCommandFlag = true;
            ast.C1.visit(this, null);
            ast.C2.visit(this, null);
            writeTxtHTML("<p><b>end</b></p>");
        }else{
            ast.C1.visit(this, null);
            ast.C2.visit(this, null);
        }
        return null;
    }

    public Object visitWhileCommand(WhileCommand ast, Object obj) {
        writeTxtHTML("<b>while</b> (");
        ast.E.visit(this, null);
        writeTxtHTML(") <b>do</b>");
        ast.C.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }
    
    @Override
    public Object visitChooseCommand(ChooseCommand ast, Object o) {
        writeTxtHTML("<b>choose</b> (");
        ast.E.visit(this, null);
        writeTxtHTML(") <b>from</b>");
        ast.C.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }
    
    @Override
    public Object visitUntilCommand(UntilCommand ast, Object o) {
        writeTxtHTML("<b>until</b> (");
        ast.E.visit(this, null);
        writeTxtHTML(") <b>do</b>");
        ast.C.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }
    
        @Override
    public Object visitForUntilCommand(ForUntilCommand ast, Object o) {
        writeTxtHTML("<b>for</b> (");
        ast.D.visit(this, null);
        writeTxtHTML(") <b>to</b>");
        ast.E1.visit(this,null);
        writeTxtHTML("<p><b>until</b></p>");
        ast.E2.visit(this, null);
        writeTxtHTML("<p><b>do;</b></p>");
        ast.C.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }

    @Override
    public Object visitForWhileCommand(ForWhileCommand ast, Object o) {
        writeTxtHTML("<b>for</b> (");
        ast.D.visit(this, null);
        writeTxtHTML(") <b>to</b>");
        ast.E1.visit(this,null);
        writeTxtHTML("<p><b>while</b></p>");
        ast.E2.visit(this, null);
        writeTxtHTML("<p><b>do;</b></p>");
        ast.C.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }
    
    @Override
    public Object visitDoUntilCommand(DoUntilCommand ast, Object o) {
        writeTxtHTML("<b>do</b> (");
        ast.C.visit(this, null);
        writeTxtHTML(") <b>until</b>");
        ast.E.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }

    @Override
    public Object visitDoWhileCommand(DoWhileCommand ast, Object o) {
        writeTxtHTML("<b>do</b> (");
        ast.C.visit(this, null);
        writeTxtHTML(") <b>while</b>");
        ast.E.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }

    @Override
    public Object visitForCommand(ForCommand ast, Object o) {
        writeTxtHTML("<b>for</b> (");
        ast.D.visit(this, null);
        writeTxtHTML(") <b>to</b>");
        ast.E.visit(this,null);
        writeTxtHTML("<p><b>do;</b></p>");
        ast.C.visit(this, null);
        writeTxtHTML("<p><b>end;</b></p>");
        return null;
    }

    // Expressions
    public Object visitArrayExpression(ArrayExpression ast, Object obj) {
        writeLineHTML("<ArrayExpression>");
        ast.AA.visit(this, null);
        writeLineHTML("</ArrayExpression>");
        return null;
    }
    
    
    public Object visitBinaryExpression(BinaryExpression ast, Object obj) {
        writeLineHTML("<BinaryExpression>");
        ast.E1.visit(this, null);
        ast.O.visit(this, null);
        ast.E2.visit(this, null);
        writeLineHTML("</BinaryExpression>");
        return null;
    }

    public Object visitCallExpression(CallExpression ast, Object obj) {
        writeLineHTML("<CallExpression>");
        ast.I.visit(this, null);
        ast.APS.visit(this, null);
        writeLineHTML("</CallExpression>");
        return null;
    }

    public Object visitCharacterExpression(CharacterExpression ast, Object obj) {
        writeLineHTML("<CharacterExpression>");
        ast.CL.visit(this, null);
        writeLineHTML("</CharacterExpression>");
        return null;
    }

    public Object visitEmptyExpression(EmptyExpression ast, Object obj) {
        writeLineHTML("<EmptyExpression/>");
        return null;
    }

    public Object visitIfExpression(IfExpression ast, Object obj) {
        writeTxtHTML("<b>if</b>");
        ast.E1.visit(this, null);
        ast.E2.visit(this, null);
        ast.E3.visit(this, null);
        return null;
    }

    public Object visitIntegerExpression(IntegerExpression ast, Object obj) {
        writeTxtHTML("<font color=#3377ff>");
        ast.IL.visit(this, null);
        writeTxtHTML("</font>");
        return null;
    }

    public Object visitLetExpression(LetExpression ast, Object obj) {
        writeTxtHTML("<p><b>let</b></p>");
        ast.D.visit(this, null);
        ast.E.visit(this, null);
        writeTxtHTML("<p><b>end</b></p>");
        return null;
    }

    public Object visitRecordExpression(RecordExpression ast, Object obj) {
        writeLineHTML("<RecordExpression>");
        ast.RA.visit(this, null);
        writeLineHTML("</RecordExpression>");
        return null;
    }

    public Object visitUnaryExpression(UnaryExpression ast, Object obj) {
        writeLineHTML("<UnaryExpression>");
        ast.O.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</UnaryExpression>");
        return null;
    }

    public Object visitVnameExpression(VnameExpression ast, Object obj) {
        writeTxtHTML("<font color=#003399>");
        ast.V.visit(this, null);
        writeTxtHTML("</font>");
        return null;
    }


    // Declarations
    public Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object obj) {
        writeLineHTML("<BinaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG1.visit(this, null);
        ast.ARG2.visit(this, null);
        ast.RES.visit(this, null);
        writeLineHTML("</BinaryOperatorDeclaration>");
        return null;
    }

    public Object visitConstDeclaration(ConstDeclaration ast, Object obj) {
        writeTxtHTML("<p style=\"text-indent: 40px\">const ");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</ConstDeclaration>");
        writeTxtHTML("</p>");
        return null;
    }

    public Object visitFuncDeclaration(FuncDeclaration ast, Object obj) {
        writeTxtHTML("<p style=\"text-indent: 40px\">func ");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        ast.E.visit(this, null);
        writeTxtHTML("</p>");
        return null;
    }

    public Object visitProcDeclaration(ProcDeclaration ast, Object obj) {
        writeTxtHTML("<p style=\"text-indent: 40px\">proc ");
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.C.visit(this, null);
        writeTxtHTML("</p>");
        return null;
    }

    public Object visitSequentialDeclaration(SequentialDeclaration ast, Object obj) {
        if(SeqDeclarationFlag == false){
            this.SeqDeclarationFlag = true;
            ast.D1.visit(this, null);
            ast.D2.visit(this, null);
            writeTxtHTML("<p><b>in</b></p>");
        }else{
            ast.D1.visit(this, null);
            ast.D2.visit(this, null);
        }
        return null;
    }

    public Object visitTypeDeclaration(TypeDeclaration ast, Object obj) {
        writeTxtHTML("<p style=\"text-indent: 40px\">type ");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeTxtHTML("</p>");
        return null;
    }

    public Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object obj) {
        writeLineHTML("<UnaryOperatorDeclaration>");
        ast.O.visit(this, null);
        ast.ARG.visit(this, null);
        ast.RES.visit(this, null);
        writeLineHTML("</UnaryOperatorDeclaration>");
        return null;
    }

    public Object visitVarDeclaration(VarDeclaration ast, Object obj) {
        writeTxtHTML("<p style=\"text-indent: 40px\">var ");
        writeTxtHTML("<font color=#003399>");
        ast.I.visit(this, null);
        writeTxtHTML("</font>");
        ast.T.visit(this, null);
        writeTxtHTML("</p>");
        return null;
    }
    
    @Override
    public Object visitForDeclaration(ForDeclaration ast, Object o) {
        writeTxtHTML("<p style=\"text-indent: 40px\">const ");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</ForDeclaration>");
        writeTxtHTML("</p>");
        return null;
    }
    
    @Override
    public Object visitPrivateDeclaration(PrivateDeclaration ast, Object o) {
        writeTxtHTML("<p style=\"text-indent: 40px\">const ");
        ast.D1.visit(this, null);
        ast.D2.visit(this, null);
        writeLineHTML("</PrivateDeclaration>");
        writeTxtHTML("</p>");
        return null;
    }
    
    @Override
    public Object visitInitVarDeclaration(InitVarDeclaration ast, Object o) {
        writeTxtHTML("<p style=\"text-indent: 40px\">const ");
        ast.E.visit(this, null);
        ast.I.visit(this, null);
        writeLineHTML("</InitVarDeclaration>");
        writeTxtHTML("</p>");
        return null;
    }
    
    @Override
    public Object visitSequentialPackageDeclaration(SequentialPackageDeclaration ast, Object o) {
        writeTxtHTML("<p style=\"text-indent: 40px\">const ");
        ast.P1.visit(this, null);
        ast.P2.visit(this, null);
        writeLineHTML("</SequentialPackageDeclaration>");
        writeTxtHTML("</p>");
        return null;
    }

    @Override
    public Object visitPackageDeclaration(PackageDeclaration ast, Object o) {
        writeTxtHTML("<p style=\"text-indent: 40px\">const ");
        ast.D.visit(this, null);
        ast.I.visit(this, null);
        writeLineHTML("</PackageDeclaration>");
        writeTxtHTML("</p>");
        return null;
    }


    // Array Aggregates
    public Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object obj) {
        writeLineHTML("<MultipleArrayAggregate>");
        ast.E.visit(this, null);
        ast.AA.visit(this, null);
        writeLineHTML("</MultipleArrayAggregate>");
        return null;
    }

    public Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object obj) {
        writeLineHTML("<SingleArrayAggregate>");
        ast.E.visit(this, null);
        writeLineHTML("</SingleArrayAggregate>");
        return null;
    }


    // Record Aggregates
    public Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object obj) {
        writeLineHTML("<MultipleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        ast.RA.visit(this, null);
        writeLineHTML("</MultipleRecordAggregate>");
        return null;
    }

    public Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object obj) {
        writeLineHTML("<SingleRecordAggregate>");
        ast.I.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</SingleRecordAggregate>");
        return null;
    }


    // Formal Parameters
    public Object visitConstFormalParameter(ConstFormalParameter ast, Object obj) {

        ast.I.visit(this, null);
        ast.T.visit(this, null);

        return null;
    }

    public Object visitFuncFormalParameter(FuncFormalParameter ast, Object obj) {
       
        ast.I.visit(this, null);
        ast.FPS.visit(this, null);
        ast.T.visit(this, null);
        
        return null;
    }

    public Object visitProcFormalParameter(ProcFormalParameter ast, Object obj) {
        ast.I.visit(this, null);
        writeTxtHTML("<font color=#003399>");
        ast.FPS.visit(this, null);
        writeLineHTML("</font>");
        return null;
    }

    public Object visitVarFormalParameter(VarFormalParameter ast, Object obj) {
        ast.I.visit(this, null);
        writeTxtHTML("<font color=#003399>");
        ast.T.visit(this, null);
        writeLineHTML("</font>");
        return null;
    }


    public Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object obj) {
        writeTxtHTML("();");
        return null;
    }

    public Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object obj) {
        writeTxtHTML("(");
        ast.FP.visit(this, null);
        ast.FPS.visit(this, null);
        writeTxtHTML(");");  
        return null;
    }

    public Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object obj) {
        writeTxtHTML("(");
        ast.FP.visit(this, null);
        writeTxtHTML(");");
        return null;
    }


    // Actual Parameters
    public Object visitConstActualParameter(ConstActualParameter ast, Object obj) {
        writeTxtHTML("(");
        ast.E.visit(this, null);
        writeTxtHTML(");");
        return null;
    }

    public Object visitFuncActualParameter(FuncActualParameter ast, Object obj) {
        writeTxtHTML("(");
        ast.I.visit(this, null);
        writeTxtHTML(");");
        return null;
    }

    public Object visitProcActualParameter(ProcActualParameter ast, Object obj) {
        writeTxtHTML("(");
        ast.I.visit(this, null);
        writeTxtHTML(");");
        return null;
    }

    public Object visitVarActualParameter(VarActualParameter ast, Object obj) {
        writeTxtHTML("( var");
        ast.V.visit(this, null);
        writeTxtHTML(");");
        return null;
    }


    public Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object obj) {
        writeTxtHTML("();");
        return null;
    }

    public Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object obj) {
        ast.AP.visit(this, null);
        ast.APS.visit(this, null);
        writeTxtHTML("</p>");
        return null;
    }

    public Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object obj) {
        ast.AP.visit(this, null);
        writeTxtHTML("</p>");
        return null;
    }


    // Type Denoters
    public Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object obj) {
        writeLineHTML("<AnyTypeDenoter/>");
        return null;
    }

    public Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object obj) {
        writeTxtHTML(": Array ");
        ast.IL.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML(";");
        return null;
    }

    public Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object obj) {
        writeTxtHTML(": Bool;");
        return null;
    }

    public Object visitCharTypeDenoter(CharTypeDenoter ast, Object obj) {
        writeTxtHTML(": Char;");
        return null;
    }

    public Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object obj) {
        writeTxtHTML(": Error;");
        return null;
    }

    public Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object obj) {
        writeLineHTML("<SimpleTypeDenoter>");
        ast.I.visit(this, null);
        writeLineHTML("</SimpleTypeDenoter>");
        return null;
    }

    public Object visitIntTypeDenoter(IntTypeDenoter ast, Object obj) {
        writeTxtHTML(": Integer;\n");
        return null;
    }

    public Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object obj) {
        writeLineHTML("<RecordTypeDenoter>");
        ast.FT.visit(this, null);
        writeLineHTML("</RecordTypeDenoter>");
        return null;
    }


    public Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object obj) {
        writeLineHTML("<MultipleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        ast.FT.visit(this, null);
        writeLineHTML("</MultipleFieldTypeDenoter>");
        return null;
    }

    public Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object obj) {
        writeLineHTML("<SingleFieldTypeDenoter>");
        ast.I.visit(this, null);
        ast.T.visit(this, null);
        writeLineHTML("</SingleFieldTypeDenoter>");
        return null;
    }


    // Literals, Identifiers and Operators
    public Object visitCharacterLiteral(CharacterLiteral ast, Object obj) {
        writeLineHTML("<font color=#3377ff>" + ast.spelling + "</font>");
        return null;
    }

    public Object visitIdentifier(Identifier ast, Object obj) {
        writeLineHTML(ast.spelling);
        return null;
    }

    public Object visitIntegerLiteral(IntegerLiteral ast, Object obj) {
        writeLineHTML("<font color=#3377ff>" + ast.spelling + "</font>");
        return null;
    }

    public Object visitOperator(Operator ast, Object obj) {
        writeLineHTML(transformOperator(ast.spelling));
        return null;
    }


    // Value-or-variable names
    public Object visitDotVname(DotVname ast, Object obj) {
        writeLineHTML("<DotVname>");
        ast.V.visit(this, null);
        ast.I.visit(this, null);
        writeLineHTML("</DotVname>");
        return null;
    }

    public Object visitSimpleVname(SimpleVname ast, Object obj) {
        writeLineHTML("<font color=#003399>");
        ast.I.visit(this, null);
        writeLineHTML("</font>");
        return null;
    }

    public Object visitSubscriptVname(SubscriptVname ast, Object obj) {
        writeLineHTML("<SubscriptVname>");
        ast.V.visit(this, null);
        ast.E.visit(this, null);
        writeLineHTML("</SubscriptVname>");
        return null;
    }
    
    @Override
    public Object visitPackageVName(PackageVName ast, Object o) {
        writeLineHTML("<SubscriptVname>");
        ast.I.visit(this, null);
        ast.V.visit(this, null);
        writeLineHTML("</SubscriptVname>");
        return null;
    }


    // Programs
    public Object visitProgram(Program ast, Object obj) {
        writeLineHTML("<html>");
        writeLineHTML("<head>\n<style>" +
                        "\n body {\nfont-size: 1em !important;\n" +
                        "font-family: Courier !important;\n}\n" +
                        "</style>\n</head>");
        writeLineHTML("<body>");
        ast.C.visit(this, null);
        writeLineHTML("\n</body>");
        writeLineHTML("\n</html>");
        return null;
    }
    
    @Override
    public Object visitProgramPackage(ProgramPackage ast, Object o) {
        writeLineHTML("<html>");
        writeLineHTML("<head>\n<style>" +
                        "\n body {\nfont-size: 1em !important;\n" +
                        "font-family: Courier !important;\n}\n" +
                        "</style>\n</head>");
        writeLineHTML("<body>");
        ast.C.visit(this, null);
        ast.P.visit(this, null);
        writeLineHTML("\n</body>");
        writeLineHTML("\n</html>");
        return null;
    }

    private void writeLineHTML(String line) {
        try {
            fileWriter.write(line);
            fileWriter.write('\n');
        } catch (IOException e) {
            System.err.println("Error while writing file for print the AST");
            e.printStackTrace();
        }
    }
    
    private void writeTxtHTML(String line) {
        try {
            fileWriter.write(line);
        } catch (IOException e) {
            System.err.println("Error while writing file for print the AST");
            e.printStackTrace();
        }
    }
    

    /*
    * Convert the characters "<" & "<=" to their equivalents in html
    */
    private String transformOperator(String operator) {
        if (operator.compareTo("<") == 0)
            return "&lt;";
        else if (operator.compareTo("<=") == 0)
            return "&lt;=";
        else
            return operator;
    }

    
    // Cases
    @Override
    public Object visitCase(Case ast, Object o) {
        writeTxtHTML("<b>when</b> (");
        ast.C1.visit(this, null);
        writeTxtHTML(") <b>then</b>");
        ast.C2.visit(this,null);
        return null;
    }
    
    @Override
    public Object visitSequentialCase(SequentialCase ast, Object o) {
        if(SeqCaseFlag == false){
            this.SeqCaseFlag = true;
            ast.C1.visit(this, null);
            ast.C2.visit(this, null);
            writeTxtHTML("<p><b>end</b></p>");
        }else{
            ast.C1.visit(this, null);
            ast.C2.visit(this, null);
        }
        return null;
    }

    @Override
    public Object visitSequentialRange(SequentialRange ast, Object o) {
        if(SeqRangeFlag == false){
            this.SeqRangeFlag = true;
            ast.R1.visit(this, null);
            ast.R2.visit(this, null);
            writeTxtHTML("<p><b>end</b></p>");
        }else{
            ast.R1.visit(this, null);
            ast.R2.visit(this, null);
        }
        return null;
    }

    @Override
    public Object visitSingleRange(SingleRange ast, Object o) {
        writeTxtHTML("<b>singleRange</b> (");
        ast.C1.visit(this, null);
        return null;
    }

    @Override
    public Object visitDualRange(DualRange ast, Object o) {
        writeLineHTML("<font color=#3377ff>");
        ast.C1.visit(this, null);
        writeLineHTML("</font>");
        writeLineHTML("<p><b> .. </p></b>");
        ast.C2.visit(this, null);
        return null;
    }

    @Override
    public Object visitElseCase(ElseCase ast, Object o) {
        writeTxtHTML("<b>else</b> (");
        ast.C.visit(this, null);
        return null;
    }

    @Override
    public Object visitCaseLiterals(CaseLiterals ast, Object o) {
        writeLineHTML("<CaseLiterals>");
        ast.CRange.visit(this, null);
        writeLineHTML("</CaseLiterals>");
        return null;
    }

    @Override
    public Object visitPackageId(PackageId ast, Object o) {
        writeLineHTML("<ComplexIdentifier>");
        ast.PckID.visit(this, null);
        ast.ID.visit(this, null);
        writeLineHTML("</ComplexIdentifier>");
        return null;
    }

    @Override
    public Object visitSimpleIdentifier(SimpleIdentifier ast, Object o) {
        writeLineHTML("<SimpleIdentifier>");
        ast.ID.visit(this, null);
        writeLineHTML("</SimpleIdentifier>");
        return null;
    }

    @Override
    public Object visitCaseIntegerLiteral(CaseIntegerLiteral ast, Object o) {
        writeLineHTML("<SimpleIdentifier>");
        ast.IL.visit(this, null);
        writeLineHTML("</SimpleIdentifier>");
        return null;
    }

    @Override
    public Object visitCaseCharacterLiteral(CaseCharacterLiteral ast, Object o) {
        writeLineHTML("<SimpleIdentifier>");
        ast.CL.visit(this, null);
        writeLineHTML("</SimpleIdentifier>");
        return null;
<<<<<<< HEAD
    }

    @Override
    public Object visitLongIdentifier(LongIdentifier ast, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
=======
>>>>>>> 19266d39baeabe117606bf7b4aa17a5dd3d94a93
    }

}
