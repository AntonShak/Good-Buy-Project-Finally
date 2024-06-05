package com.shakov.goodbuyproject.integrartion.http.controller;

import com.shakov.goodbuyproject.database.entity.Role;

import com.shakov.goodbuyproject.integrartion.IntegrationTestBase;
import com.shakov.goodbuyproject.integrartion.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static com.shakov.goodbuyproject.dto.UserCreateEditDto.Fields.*;
import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@IT
@RequiredArgsConstructor
@AutoConfigureMockMvc
public class UserControllerTest extends IntegrationTestBase {

    @Autowired
    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {


        mockMvc.perform(get("/users").with(user("test@gmail.com").authorities(Role.ADMIN)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", hasSize(2)));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                        .param(username, "test@gmail.com")
                        .param(rawPassword, "test")
                        .param(firstname, "Test")
                        .param(lastname, "Test")
                        .param(birthDate, String.valueOf(LocalDate.now()))
                        .param(phone, "+123456789")
                        .param(role, String.valueOf(Role.ADMIN)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }

}
