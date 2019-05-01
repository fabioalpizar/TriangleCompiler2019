/*
 * @(#)Scanner.java                        2.1 2003/10/07
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

package Triangle.tools.Triangle.SyntacticAnalyzer;
import Triangle.tools.Triangle.HTMLWriter.Writer;


public final class Scanner {

	//Se añadieron los atributos de htmlWriter y htmlCode para la creacion de archivos html
  private SourceFile sourceFile;
  private boolean debug;
  private Writer htmlWriter;
  private char currentChar;
  private StringBuffer currentSpelling;
  private boolean currentlyScanningToken;
  private String htmlCode = "";

  private boolean isLetter(char c) {
    return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return (c >= '0' && c <= '9');
  }

// isOperator returns true iff the given character is an operator character.

  private boolean isOperator(char c) {
    return (c == '+' || c == '-' || c == '*' || c == '/' ||
	    c == '=' || c == '<' || c == '>' || c == '\\' ||
	    c == '&' || c == '@' || c == '%' || c == '^' ||
	    c == '?');
  }


///////////////////////////////////////////////////////////////////////////////

  public Scanner(SourceFile source) {
    sourceFile = source;
    htmlWriter = new Writer(sourceFile.getFilename());
    currentChar = sourceFile.getSource();
    debug = false;
  }

  public void enableDebugging() {
    debug = true;
  }

  // takeIt appends the current character to the current token, and gets
  // the next character from the source program.

  private void takeIt() {
    if (currentlyScanningToken)
      currentSpelling.append(currentChar);
    currentChar = sourceFile.getSource();
  }

  // scanSeparator skips a single separator.

  /*
  	Se modifican los casos para que se pueda representar cada uno de estos casos en el html
  */
  private void scanSeparator() {
    switch (currentChar) {
    case '!':
      {
        htmlCode += "<p style=\"color:MediumSeaGreen;\">" + currentChar;
        takeIt();
        while ((currentChar != SourceFile.EOL) && (currentChar != SourceFile.EOT)){
          htmlCode += currentChar;
          takeIt();
        }
        if (currentChar == SourceFile.EOL){
          takeIt();
        }
        htmlCode += "</p>";
      }
      break;

    case ' ':
      htmlCode += "&nbsp;";
      takeIt();
      break;
    case '\t':
        htmlCode+= "&nbsp;&nbsp;&nbsp;&nbsp;";
    case '\n': case '\r':
        htmlCode += "<p></p>";
        takeIt();
        break;
    }
  }

  /*
  En el método scanToken se añade la funcionalidad necesaria para poder implementar los nuevos tokens:
  - Para el case donde se lee un ‘ . ‘, se definió una condición donde sí al hacer ejecutar takeIt, el 
  	currenChar es un ‘ . ’, se retorna al token de DOUBLEDOT, sino, se retorna a DOT.
  -	Para el case donde se lee un ‘ : ’, se expandió la condición que venía en el caso, 
  	donde previamente se tenía la condición para el ‘=’ para retornar un BECOMES y si no lo era retornaba 
  	COLON directamente, ahora se tiene un else if donde si el carácter que le sigue es un ‘:’ se entra a 
  	otra condición, el cual pregunta, si al ejecutar takeIt el currentChar es un ‘=’ se retorna el SINGLEDECLARATION.
  -	Se añade el case para el token PIPE ( | )
  -	Se añade el case para el token DOLLAR ( $ )
  */
  private int scanToken() {

    switch (currentChar) {

    case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
    case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
    case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
    case 'p':  case 'q':  case 'r':  case 's':  case 't':
    case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
    case 'z':
    case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
    case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
    case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
    case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
    case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
    case 'Z':
      takeIt();
      while (isLetter(currentChar) || isDigit(currentChar)){
        takeIt();
      }

      return Token.IDENTIFIER;

    case '0':  case '1':  case '2':  case '3':  case '4':
    case '5':  case '6':  case '7':  case '8':  case '9':
      takeIt();
      while (isDigit(currentChar))
        takeIt();
      return Token.INTLITERAL;

    case '+':  case '-':  case '*': case '/':  case '=':
    case '<':  case '>':  case '\\':  case '&':  case '@':
    case '%':  case '^':  case '?':
      takeIt();
      while (isOperator(currentChar))
        takeIt();
      return Token.OPERATOR;

    case '\'':
      takeIt();
      takeIt(); // the quoted character
      if (currentChar == '\'') {
      	takeIt();
        return Token.CHARLITERAL;
      } else
        return Token.ERROR;

    case '.':
      takeIt();
      if(currentChar == '.'){
        takeIt();
        return Token.DOUBLEDOT;
      }
      return Token.DOT;

    case ':':
      takeIt();
      if (currentChar == '=') {
        takeIt();
        return Token.BECOMES;
      }
      else if(currentChar == ':'){
        takeIt();
        if(currentChar == '='){
          takeIt();
          return Token.SINGLEDECLARATION;
        }
      } else
        return Token.COLON;

    case ';':
      takeIt();
      return Token.SEMICOLON;

    case ',':
      takeIt();
      return Token.COMMA;

    case '~':
      takeIt();
      return Token.IS;

    case '|':
      takeIt();
      return Token.PIPE;

    case '$':
      takeIt();
      return Token.DOLLAR;

    case '(':
      takeIt();
      return Token.LPAREN;

    case ')':
      takeIt();
      return Token.RPAREN;

    case '[':
      takeIt();
      return Token.LBRACKET;

    case ']':
      takeIt();
      return Token.RBRACKET;

    case '{':
      takeIt();
      return Token.LCURLY;

    case '}':
      takeIt();
      return Token.RCURLY;

    case SourceFile.EOT:
      
      return Token.EOT;

    default:
      takeIt();
      return Token.ERROR;
    }
  }

  /*
  	Se añaden la lectura de los tokens para crear el respectivo HTML con los colores solicitados
  	Se va creando el codigo html con las caracteristicas respectivas del token, o en dado
  	caso de que sea un comentario. 
  */
  public Token scan () {
    Token tok;
    SourcePosition pos;
    int kind;

    currentlyScanningToken = false;
    while (currentChar == '!'
           || currentChar == ' '
           || currentChar == '\n'
           || currentChar == '\r'
           || currentChar == '\t')
      scanSeparator();

    currentlyScanningToken = true;
    currentSpelling = new StringBuffer("");
    pos = new SourcePosition();
    pos.start = sourceFile.getCurrentLine();

    kind = scanToken();
    if (kind == Token.IDENTIFIER) {
      int newKind = new Token(Token.IDENTIFIER, currentSpelling.toString(), pos).kind;
      if (newKind != kind){
        htmlCode += "<span><b>" + currentSpelling.toString() + " </b></span>";
      }
      else{
        htmlCode += currentSpelling.toString()+" ";
      }
    }
    else if (kind == Token.CHARLITERAL || kind == Token.INTLITERAL){
      htmlCode += "<span style=\"color:DarkBlue;\">"+currentSpelling.toString()+" </span>";
    }
    else if( kind == Token.EOT){
      htmlWriter.write(htmlCode);
    }
    else{
      htmlCode += currentSpelling.toString()+" ";
    }

    pos.finish = sourceFile.getCurrentLine();
    tok = new Token(kind, currentSpelling.toString(), pos);
    if (debug)
      System.out.println(tok);
    return tok;
  }
}