package com.jorge.RestCrud.Services;

import com.jorge.RestCrud.Entities.User;
import com.jorge.RestCrud.Repositorys.UserRepository;
import com.jorge.RestCrud.Services.Interfaces.IGetAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllService implements IGetAllService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<User>();
        repo.findAll().forEach(user -> users.add(user));
        return users;
    }


}
