package org.prasanna.service.serviceSpec;

import java.util.List;

import org.jboss.resteasy.reactive.RestResponse;
import org.prasanna.dto.UserDTO;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface UserServiceSpec {

	//Add user 
	RestResponse<String> addUser(UserDTO userDTO);
	
	//getAllUsers
	RestResponse<List<UserDTO>> getAllUsers();
	
	//getUserById
	RestResponse<UserDTO> getUserById(String id);
	
	//deleteUser
	RestResponse<String> deleteUser(String id);
	
	//updateUser
	RestResponse<String> updateUser(UserDTO userDTO);
}
