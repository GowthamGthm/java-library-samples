package com.gthm.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gthm.libraries.mapstruct.dto.UserEntityDto;
import com.gthm.libraries.mapstruct.entity.UserEntity;
import com.gthm.libraries.mapstruct.regularmapper.UserMapper;
import org.instancio.Instancio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class TestService {


    @Autowired
    UserMapper userMapper;

    public List<UserEntityDto> run() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<UserEntityDto> list = IntStream.range(0, 10)
                                            .boxed()
                                            .map(e -> Instancio.create(UserEntity.class))
                                            .peek(e -> System.out.println(e))
                                            .map(e -> userMapper.toDto(e))
                                            .toList();

        return list;

    }


}