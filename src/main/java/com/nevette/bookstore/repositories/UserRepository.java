package com.nevette.bookstore.repositories;

import com.nevette.bookstore.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
