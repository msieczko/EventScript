package com.github.mikee2509.eventscript.parser.exception;

import com.github.mikee2509.eventscript.domain.expression.Type;
import org.antlr.v4.runtime.Token;

import java.text.MessageFormat;

public class ScopeException extends ParserException {
    private ScopeException(Token token, String message) {
        super(token, message);
    }

    public static ScopeException alreadyDefined(Token token) {
        return new ScopeException(token, MessageFormat.format("'{0}' is already defined in this scope",
            token.getText()));
    }

    public static ScopeException cannotBeDefined(Token token, Type type) {
        return new ScopeException(token, MessageFormat.format("Variable of type {0} cannot be defined",
            type.getName()));
    }

}