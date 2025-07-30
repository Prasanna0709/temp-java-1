package org.prasanna.controller;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;
import org.prasanna.controller.controllerSpec.UserControllerSpec;
import org.prasanna.dto.UserDTO;
import org.prasanna.service.serviceSpec.UserServiceSpec;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path("/api/users")
public class UserController implements UserControllerSpec {
	
	@Inject
	UserServiceSpec userServiceSpec;
	
	@Override
	public RestResponse<String> addUser(UserDTO userDTO){
		return userServiceSpec.addUser(userDTO);
	}
	
	
	@Override
	public RestResponse<List<UserDTO>> getAllUsers(){
		return userServiceSpec.getAllUsers();
	}
	
	
	@Override
	public RestResponse<UserDTO> getUserById(String id){
		return userServiceSpec.getUserById(id);
	}
	
	
	@Override
	public RestResponse<String> deleteUser(String id){
		return userServiceSpec.deleteUser(id);
	}
	
	@Override
	public RestResponse<String> updateUser(UserDTO userDTO){
		return userServiceSpec.updateUser(userDTO);
	}
	
}
