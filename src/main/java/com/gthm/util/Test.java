package com.gthm.util;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {

//        UserEntity userEntity = Instancio.create(UserEntity.class);
//        userEntity.setName("null");
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        System.out.println(mapper.writeValueAsString(userEntity));


        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i - 10);
        }
        System.out.println(s.size());


    }

}