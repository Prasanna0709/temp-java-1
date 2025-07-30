package org.prasanna.controller.controllerSpec;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;
import org.prasanna.dto.UserDTO;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

public interface UserControllerSpec {
	
	
	// Add User API
	@Path("/add-user")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	RestResponse<String> addUser(UserDTO userDTO);
	
	
	// Get All Users
	@Path("/get-all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<List<UserDTO>> getAllUsers();
	
	
	// Get UserById
	@Path("/get-user/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<UserDTO> getUserById(@PathParam("id") String id);
	
	
	// Delete User 
	@Path("/delete-user/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	RestResponse<String> deleteUser(@PathParam("id") String id);
	
	
	// Update User
	@Path("/update-user")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	RestResponse<String> updateUser(UserDTO userDTO);
	

}
