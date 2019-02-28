package Grambois.controllers;

import Grambois.services.TextService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/text")
public class TextController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getText(@QueryParam("textID") Integer textID) throws JsonProcessingException {
        String text = TextService.getInstance().getText();
        ObjectMapper mapper = new ObjectMapper();
        String textJson = mapper.writeValueAsString(text);
        return textJson;
    }
}
