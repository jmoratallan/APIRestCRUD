package com.jorge.RestCrud.Repositorys;

import com.jorge.RestCrud.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {}