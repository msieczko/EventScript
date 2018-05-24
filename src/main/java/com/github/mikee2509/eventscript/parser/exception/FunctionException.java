package com.github.mikee2509.eventscript.parser.exception;

import com.github.mikee2509.eventscript.domain.expression.Type;
import org.antlr.v4.runtime.Token;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionException extends ParserException {
    private FunctionException(Token token, String message) {
        super(token, message);
    }

    public static FunctionException voidParameter(Token token) {
        return new FunctionException(token, "Function parameter cannot be of void type");
    }

    public static FunctionException argumentException(Token token, String function, List<Type> paramTypes) {
        String parameterList = paramTypes.stream()
            .map(Type::getName)
            .collect(Collectors.joining(", ", "(", ")"));
        return new FunctionException(token, MessageFormat.format("Function {0} expects parameters of types {1}",
            function, parameterList));
    }
}
