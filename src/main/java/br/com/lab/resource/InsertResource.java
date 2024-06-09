package br.com.lab.resource;

import br.com.lab.dto.PayloadDTO;
import br.com.lab.dto.ResponseDTO;
import br.com.lab.service.RedisService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/insert")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InsertResource {

    @Inject
    private RedisService redisService;

    @Inject
    private ObjectMapper objectMapper;

    @POST
    public Response insertData(PayloadDTO payloadDTO) throws Exception {
        this.redisService.set(payloadDTO.getKey(), payloadDTO.getValue());
        ResponseDTO responseDTO = new ResponseDTO(UUID.randomUUID().toString());
        return Response.status(Response.Status.CREATED).entity(responseDTO).build();
    }
}
