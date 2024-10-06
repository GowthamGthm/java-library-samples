package com.gthm.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gthm.entity.UserEntity;
import org.instancio.Instancio;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {

        UserEntity userEntity = Instancio.create(UserEntity.class);
        userEntity.setName("null");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        System.out.println(mapper.writeValueAsString(userEntity));


    }
    
}