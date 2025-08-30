package com.example.UnitTestRestfulWebServicesTestCRUD;

import com.example.UnitTestRestfulWebServicesTestCRUD.controller.UserRestController;
import com.example.UnitTestRestfulWebServicesTestCRUD.entity.User;
import com.example.UnitTestRestfulWebServicesTestCRUD.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

    @Autowired
    private UserRestController userRestController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void saveUserTest() throws Exception {
        User newUser = User.builder()
                .id(1)
                .name("John")
                .build();

        //mock the user data that we have to save
        when(userService.saveUser(any(User.class))).thenReturn(newUser);


        //mock request "/user/save"
        mockMvc.perform(MockMvcRequestBuilders.post("/user/save")
                .content(new ObjectMapper().writeValueAsString(newUser))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"));
    }

    @Test
    public void getUserByIdTest() throws Exception {

        //mock the data return by the UserService class
        when(userService.getUserById(anyInt())).thenReturn(User.builder()
                        .id(12)
                .name("John")
                .build());

        //create a mock HTTP request to verify the expected result
        mockMvc.perform(MockMvcRequestBuilders.get("/user/12"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(12))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
                .andExpect(status().isOk());

    }
}
