package org.prasanna.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;
import org.prasanna.dto.UserDTO;
import org.prasanna.entity.UserEntity;
import org.prasanna.mapper.UserMapper;
import org.prasanna.repository.UserRepository;
import org.prasanna.service.serviceSpec.UserServiceSpec;
import org.prasanna.utility.UserUtility;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserServiceImpl implements UserServiceSpec {
	
	@Inject
	UserRepository userRepository;
	
	@Override
	public RestResponse<String> addUser(UserDTO userDTO){
		
		Boolean isValidCredentials = UserUtility.validateUserDetails(userDTO);
		if(!isValidCredentials) {
			return RestResponse.status(Status.BAD_REQUEST, "Please enter the valid credentials !");
		}
		
		UserEntity userEntity = UserEntity.builder()
				.name(userDTO.getName())
				.age(userDTO.getAge())
				.email(userDTO.getEmail())
				.organizationName(userDTO.getOrganizationName())
				.createdAt(LocalDateTime.now())
				.build();	
		
		
		userEntity.persist();
		
		Object id = userEntity.id;
		if(id==null || id=="")
			return RestResponse.status(Status.INTERNAL_SERVER_ERROR,"Something went wrong in creating the user !");
		
		return RestResponse.status(Status.CREATED, "User created successfully !");
	}

	public RestResponse<List<UserDTO>> getAllUsers(){
		List<UserEntity> entities = userRepository.findAll().list();
	
		List<UserDTO> userDTOs = entities
				.stream()
				.map(UserMapper::userDtoMapper).toList();
		
		return RestResponse.status(Status.OK,userDTOs);
	}
	
	public RestResponse<UserDTO> getUserById(String id){
		UserEntity userEntity = userRepository.findById(new ObjectId(id));
		
		if(userEntity==null)
			return RestResponse.status(Status.NOT_FOUND);
		
		UserDTO userDTO = UserDTO.builder()
				.id(userEntity.id.toString())
				.name(userEntity.getName())
				.age(userEntity.getAge())
				.email(userEntity.getEmail())
				.organizationName(userEntity.getOrganizationName())
				.createdAt(userEntity.getCreatedAt())
				.build();
		
		return RestResponse.status(Status.OK, userDTO);
		
	}
	
	public RestResponse<String> deleteUser(String id){
		UserEntity userEntity = userRepository.findById(new ObjectId(id));
		if(userEntity==null)
			return RestResponse.status(Status.NOT_FOUND,"User Not found !");
		
		userRepository.deleteById(new ObjectId(id));
		return RestResponse.status(Status.OK, "User deleted Successfully !");
	}
	
	public RestResponse<String> updateUser(UserDTO userDTO){
		UserEntity userEntity = userRepository.findById(new ObjectId(userDTO.getId()));
		
		if(userEntity == null)
			return RestResponse.status(Status.NOT_FOUND, "User not found !");
		
		userEntity.setEmail(StringUtils.isNotBlank(userDTO.getEmail())?userDTO.getEmail():userEntity.getEmail());
		userEntity.setAge(userDTO.getAge()!=0 ? userDTO.getAge():userEntity.getAge());
		userEntity.setName(StringUtils.isNotBlank(userDTO.getName())? userDTO.getName():userEntity.getName());
		userEntity.setOrganizationName(StringUtils.isNotBlank(userDTO.getOrganizationName())?userDTO.getOrganizationName():userEntity.getOrganizationName());
		
		userRepository.update(userEntity);
		return RestResponse.status(200, "User successfully updated !");
	}
}
