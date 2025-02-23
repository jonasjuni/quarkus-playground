package dev.jcsj.playground.Exceptions;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import jakarta.ws.rs.NotAcceptableException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MyJsonProcessingExceptionHandler implements ExceptionMapper<MismatchedInputException> {

    @Override
    public Response toResponse(MismatchedInputException exception) {
        var path = exception.getPath();
        var message = exception.getMessage();
        var test = exception.getPathReference();
        var c = exception.getTargetType();
        var location = exception.getLocation();
        var cause = exception.getCause();
        var msg = exception.getOriginalMessage();
        var msg2 = exception.getMessage();
        var msg3 = exception.getLocalizedMessage();

        var fieldname = path.get(0).getFieldName();

        throw new NotAcceptableException("invalid request");
    }

}
