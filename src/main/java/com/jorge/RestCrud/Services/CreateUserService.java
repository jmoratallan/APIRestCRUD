package com.jorge.RestCrud.Services;

import com.jorge.RestCrud.Entities.User;
import com.jorge.RestCrud.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService {

    @Autowired
    private UserRepository repo;

    public void createUser(User user) {
        repo.save(user);
    }
}
