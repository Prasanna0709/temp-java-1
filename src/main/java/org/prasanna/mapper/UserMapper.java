package org.prasanna.mapper;

import org.prasanna.dto.UserDTO;
import org.prasanna.entity.UserEntity;

public class UserMapper {
	
	private UserMapper() {}

	public static UserDTO userDtoMapper(UserEntity userEntity) {
		return UserDTO.builder()
				.id(userEntity.id.toString())
				.name(userEntity.getName())
				.age(userEntity.getAge())
				.email(userEntity.getEmail())
				.organizationName(userEntity.getOrganizationName())
				.createdAt(userEntity.getCreatedAt())
				.build();
	}
	
}
