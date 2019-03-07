package com.jorge.RestCrud.controllers;


import com.jorge.RestCrud.Entities.User;
import com.jorge.RestCrud.Exceptions.UserExistException;
import com.jorge.RestCrud.Exceptions.UserNotFoundException;
import com.jorge.RestCrud.Repositorys.UserRepository;
import com.jorge.RestCrud.Services.CreateUserService;
import com.jorge.RestCrud.Services.DeleteUserService;
import com.jorge.RestCrud.Services.GetAllService;
import com.jorge.RestCrud.Services.GetByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;

@RestController
public class RestControllerMain {
    @Autowired
    private UserRepository repo;

    @Autowired
    private GetAllService getAllService;

    @Autowired
    private GetByIdService getByIdService;

    @Autowired
    private DeleteUserService deleteService;

    @Autowired
    private CreateUserService createService;


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(value = "/GetAll")
    public String getAll(){
        //Pintamos la lista de usuarios encontrados
        return getAllService.getAllUsers().toString();
    }


    @ResponseStatus(value = HttpStatus.FOUND)
    @GetMapping(value = "/GetByID/{id}")
    public String getById(@PathVariable("id") int id){
        //Pintamos el usuario encontrado por ese id

        if(!repo.existsById(id))throw new UserNotFoundException();

        return getByIdService.getByIDUser(id).toString();
    }

    @DeleteMapping("/DeleteUser/{id}")
    private ResponseEntity<Object> deleteUser(@PathVariable("id") int id) {
        //Comprobamos primero que el usuario existe
        if(!repo.existsById(id)) throw new UserNotFoundException();

        //Borramos usuario encontrado por id
        deleteService.delete(id);
        return new ResponseEntity<>("User deleted", HttpStatus.FOUND);
    }

    @PostMapping(value = "/CreateUser")
    private  ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
        //Insertamos previamente a comprobar que no existe ya el usuario
        //Comprobamos el 0 por si el JSON del body desde Postman/Rest client/(otro) no especifica el id, lo cual le asigna 0 y no entra en la condición de la excepcion manipulada
        if(user.getId() != 0 && repo.existsById(user.getId())) throw new UserExistException();

        createService.createUser(user);
        return new ResponseEntity<>("User created.", HttpStatus.CREATED);
    }
}
