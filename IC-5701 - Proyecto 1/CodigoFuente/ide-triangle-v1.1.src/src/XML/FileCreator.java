/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;
import XML.HtmlVisitors;
import XML.XmlVisitors;
import Triangle.AbstractSyntaxTrees.Program;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.TransformerException;


public class FileCreator {

    private String fileNameXML;
    private String fileNameHTML;

    public FileCreator(String fileNameXML, String fileNameHTML) {
        this.fileNameXML = fileNameXML + ".xml";
        this.fileNameHTML = fileNameHTML + ".html";
    }

    // Draw the AST representing a complete program.
    public void writeXML(Program ast) throws TransformerException {
        // Prepare the file to write
        try {
            FileWriter fileWriter = new FileWriter(fileNameXML);

            //XML header
            fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

            XmlVisitors layout = new XmlVisitors(fileWriter);
            ast.visit(layout, null);

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }

    // Draw the AST representing a complete program.
    public void writeHTML(Program ast) throws TransformerException {
        // Prepare the file to write
        try {
            FileWriter fileWriter = new FileWriter(fileNameHTML);

            HtmlVisitors layout = new HtmlVisitors(fileWriter);
            ast.visit(layout, null);

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }
    
}
