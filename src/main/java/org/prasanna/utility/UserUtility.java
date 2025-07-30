package org.prasanna.utility;

import org.apache.commons.lang3.StringUtils;
import org.prasanna.dto.UserDTO;

public class UserUtility {

	private UserUtility() {}
	
	public static Boolean validateUserDetails(UserDTO userDTO) {
		
		if(userDTO == null) {
			return false;
		}
		
		return StringUtils.isNotBlank(userDTO.getEmail())
				&& StringUtils.isNotBlank(userDTO.getName())
				&& StringUtils.isNotBlank(userDTO.getOrganizationName())
				&& (userDTO.getAge() != 0);
		
	}
	
}
