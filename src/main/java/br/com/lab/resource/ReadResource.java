package br.com.lab.resource;

import br.com.lab.exception.KeyNotFoundException;
import br.com.lab.service.RedisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Objects;

@Path("/read")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReadResource {

    @Inject
    private RedisService redisService;

    @Inject
    private ObjectMapper objectMapper;

    @GET
    @Path("/{key}")
    public Response get(@PathParam("key") String key) {
        String response = redisService.get(key);

        if (Objects.isNull(response)) {
            throw new KeyNotFoundException("Dado não encontrado na base de dados");
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }
}
