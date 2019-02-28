package Grambois.controllers;

import Grambois.services.TextService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/text")
public class TextController {

    @GET
    @Path("/{textID}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getText(@PathParam("textID") Integer textID) throws JsonProcessingException {
        String text = TextService.getInstance().getText(textID);
        ObjectMapper mapper = new ObjectMapper();
        String textJson = mapper.writeValueAsString(text);
        return textJson;
    }
}
