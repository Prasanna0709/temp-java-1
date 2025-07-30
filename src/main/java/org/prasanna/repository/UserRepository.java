package org.prasanna.repository;

import org.prasanna.entity.UserEntity;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<UserEntity> {

}
