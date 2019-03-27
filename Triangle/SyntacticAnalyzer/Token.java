/*
 * @(#)Token.java                        2.1 2003/10/07
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

package Triangle.SyntacticAnalyzer;


final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL  = 0,
    CHARLITERAL = 1,
    IDENTIFIER  = 2,
    OPERATOR    = 3,

    // reserved words - must be in alphabetical order...
    // Se cambió la numeración
    ARRAY       = 4,
    // Se eliminó la palabra reservada begin
    CHOOSE  = 5,   // Se agregó palabra reservada choose
    CONST   = 6,
    DO      = 7,
    ELSE    = 8,
    END     = 9,
    FUNC    = 10,
    FOR     = 11,   // Se agregó palabra reservada for
    FROM    = 12,   // Se agregó palabra reservada from
    IF      = 13,
    IN      = 14,
    LET     = 15,
    LOOP    = 16,   // Se agregó palabra reservada loop
    OF      = 17,
    PAR     = 18,   // Se agregó palabra reservada par
    PASS    = 19,   // Se agregó palabra reservada pass
    PRIVATE = 20,   // Se agregó palabra reservada private
    PROC    = 21,
    RECORD  = 22,
    RECURSIVE   = 23,   // Se agregó palabra reservada recursive
    THEN        = 24,
    TO      = 25,   // Se agregó palabra reservada to
    TYPE    = 26,
    UNTIL   = 27,   // Se agregó palabra reservada until
    VAR     = 28,
    WHEN    = 29,   // Se agregó palabra reservada when
    WHILE   = 30,
  
    // punctuation...
    DOT         = 31,
    COLON       = 32,
    SEMICOLON   = 33,
    COMMA       = 34,
    BECOMES     = 35,
    IS          = 36,
    PIPE        = 37,   // Se agregó simbolo |
    INITIALIZE  = 38,   // Se agregó simbolo ::=
    DOLLAR      = 39,   // Se agregó simbolo $
    RANGE       = 40,   // Se agregó simbolo ..

    // brackets...
    LPAREN      = 41,
    RPAREN      = 42,
    LBRACKET    = 43,
    RBRACKET    = 44,
    LCURLY      = 45,
    RCURLY      = 46,

    // special tokens...
    EOT         = 47,
    ERROR       = 48;

  private static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "choose",   // Se agregó el caracter de la palabra reservada choose
    "const",
    "do",
    "else",
    "end",
    "func",
    "for",   // Se agregó el caracter de la palabra reservada for
    "from",   // Se agregó el caracter de la palabra reservada from
    "if",
    "in",
    "let",
    "loop",   // Se agregó el caracter de la palabra reservada loop
    "of",
    "par",   // Se agregó el caracter de la palabra reservada par
    "pass",   // Se agregó el caracter de la palabra reservada pass
    "private",   // Se agregó el caracter de la palabra reservada private
    "proc",
    "record",
    "recursive",   // Se agregó el caracter de la palabra reservada recursive
    "then",
    "to",   // Se agregó el caracter de la palabra reservada to
    "type",
    "until",   // Se agregó el caracter de la palabra reservada until
    "var",
    "when",   // Se agregó el caracter de la palabra reservada when
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",   // Se agregó el caracter del simbolo |
    "::=",   // Se agregó el caracter del simbolo ::=
    "$",   // Se agregó el caracter del simbolo $
    "..",   // Se agregó el caracter del simbolo ..
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

  private final static int  firstReservedWord = Token.ARRAY,
                lastReservedWord  = Token.WHILE;

}
