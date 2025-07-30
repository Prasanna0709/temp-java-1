package org.prasanna.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
	private String id;
	private String name;
	private int age;
	private String email;
	private String organizationName;
	private LocalDateTime createdAt;
}
