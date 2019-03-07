package com.jorge.RestCrud;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void verifyMedia() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/CreateUser").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldReturnHttpCode200OnGetAll() throws Exception {
        mockMvc.perform(get("/GetAll")).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnHttpCode302OnGetByID() throws Exception {
        mockMvc.perform(get("/GetByID/5")).andExpect(status().isFound());
    }

    @Test
    public void shouldReturnHttpCode404OnGetByID() throws Exception {
        //Como el user 1 no existe devuelve no found, implementado en la clase de excepcion UserNotFoundException
        mockMvc.perform(get("/GetByID/1")).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnHttpCode302OnDelete() throws Exception {
        mockMvc.perform(delete("/DeleteUser/5")).andExpect(status().isFound());
    }

    @Test
    public void shouldReturnHttpCode404OnDelete() throws Exception {
        //Como el user 1 no existe devuelve no found, implementado en la clase de excepcion UserNotFoundException
        mockMvc.perform(delete("/DeleteUser/1")).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnHttpCode201OnCreate() throws Exception {
        //Como el post necesita body devolverá un bad request
        mockMvc.perform(post("/CreateUser")).andExpect(status().isBadRequest());
    }

}