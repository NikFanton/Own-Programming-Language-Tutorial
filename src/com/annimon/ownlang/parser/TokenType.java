package com.annimon.ownlang.parser;

/**
 *
 * @author aNNiMON
 */
public enum TokenType {

    NUMBER,
    HEX_NUMBER,
    WORD,
    TEXT,
    
    // keyword
    PRINT,
    IF,
    ELSE,
    
    PLUS,
    MINUS,
    STAR,
    SLASH,
    EQ,
    EQEQ,
    EXCL,
    EXCLEQ,
    LT,
    LTEQ,
    GT,
    GTEQ,
    
    BAR,
    BARBAR,
    AMP,
    AMPAMP,
    
    LPAREN, // (
    RPAREN, // )
    
    EOF
}
