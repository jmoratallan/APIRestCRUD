package com.jorge.RestCrud.Services;

import com.jorge.RestCrud.Entities.User;
import com.jorge.RestCrud.Exceptions.UserNotFoundException;
import com.jorge.RestCrud.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetByIdService {

    @Autowired
    private UserRepository repo;
    
    public User getByIDUser(int id) {

        return repo.findById(id).get();
    }
}
