package br.com.lab.handler;

import br.com.lab.dto.ErroDTO;
import br.com.lab.dto.TemplateErrorDTO;
import br.com.lab.exception.KeyNotFoundException;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.ArrayList;
import java.util.List;

@Provider
@Priority(Priorities.USER)
public class KeyNotFoundExceptionHandler implements ExceptionMapper<KeyNotFoundException> {

    @Override
    public Response toResponse(KeyNotFoundException e) {
        ErroDTO errorDTO = new ErroDTO(e.getMessage());
        List<ErroDTO> errors = new ArrayList<>();
        errors.add(errorDTO);
        TemplateErrorDTO templateErrorDTO = new TemplateErrorDTO(errors);
        return Response.status(422).entity(templateErrorDTO).build();
    }
}
