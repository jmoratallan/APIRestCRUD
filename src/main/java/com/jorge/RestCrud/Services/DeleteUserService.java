package com.jorge.RestCrud.Services;

import com.jorge.RestCrud.Repositorys.UserRepository;
import com.jorge.RestCrud.Services.Interfaces.IDeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserService implements IDeleteUserService {

    @Autowired
    private UserRepository repo;

    public void delete(int id) {
        repo.deleteById(id);
    }
}
