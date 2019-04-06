
package Triangle.SyntacticAnalyzer;

import Triangle.SyntacticAnalyzer.SourcePosition;

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
    PACKAGE = 18,
    PAR     = 19,   // Se agregó palabra reservada par
    PASS    = 20,   // Se agregó palabra reservada pass
    PRIVATE = 21,   // Se agregó palabra reservada private
    PROC    = 22,
    RECORD  = 23,
    RECURSIVE   = 24,   // Se agregó palabra reservada recursive
    THEN        = 25,
    TO      = 26,   // Se agregó palabra reservada to
    TYPE    = 27,
    UNTIL   = 28,   // Se agregó palabra reservada until
    VAR     = 29,
    WHEN    = 30,   // Se agregó palabra reservada when
    WHILE   = 31,
  
    // punctuation...
    DOT         = 32,
    COLON       = 33,
    SEMICOLON   = 34,
    COMMA       = 35,
    BECOMES     = 36,
    IS          = 37,
    PIPE        = 38,   // Se agregó simbolo |
    INITIALIZE  = 39,   // Se agregó simbolo ::=
    DOLLAR      = 40,   // Se agregó simbolo $
    RANGE       = 41,   // Se agregó simbolo ..

    // brackets...
    LPAREN      = 42,
    RPAREN      = 43,
    LBRACKET    = 44,
    RBRACKET    = 45,
    LCURLY      = 46,
    RCURLY      = 47,

    // special tokens...
    EOT         = 48,
    ERROR       = 49;
  
    // package

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
    "package",
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