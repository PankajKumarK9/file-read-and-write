package com.sunglowsys.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sunglowsys.domain.User;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping
public class UserController {

    private static final String JSON_FILE_PATH = "Downloads/degree.pdf";
    private final ObjectMapper objectMapper;



    public UserController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @PostMapping("/write")
    public void readJsonFile(@RequestBody User user) throws IOException {
        try {
            objectMapper.writeValue(new File("C:/read/aa.json"),user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/read")
    public User writeJsonFile() throws IOException {
        User user = new User();
        try {
            user = objectMapper.readValue(new File("C:/read/aa.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}



