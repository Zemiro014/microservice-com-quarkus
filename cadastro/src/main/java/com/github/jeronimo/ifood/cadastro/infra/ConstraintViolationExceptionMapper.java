package com.github.jeronimo.ifood.cadastro.infra;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// Fará o mapeamento da exceção sobre a violação de constraint. Toda vez que o "ConstraintViolationException" for lançada, será mapeado
@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Status.BAD_REQUEST).entity(ConstraintViolationResponse.of(exception)).build();
    }
}
