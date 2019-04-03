package Grambois.controllers;

import Grambois.pojos.User;
import Grambois.pojos.UserDto;
import Grambois.services.UserService;
import Grambois.tools.PasswdUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/usrcontrol")
public class UserController {


    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDto userDto){
        System.out.println("here");
        User user = new User(userDto);
        UserService.getInstance().createUser(user.getMail(), PasswdUtil.genererMotDePasse(user.getPwd()));
        return Response.status(201).build();
    }
    */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(){
        return null;
    }
}
