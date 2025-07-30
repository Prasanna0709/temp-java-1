package org.prasanna.entity;

import java.time.LocalDateTime;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@MongoEntity(collection = "userDeployment")
public class UserEntity extends PanacheMongoEntity {

	private String name;
	private String email;
	private int age;
	private String organizationName;
	private LocalDateTime createdAt;
	
}
