package com.gthm;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gthm.dto.UserEntityDto;
import com.gthm.entity.UserEntity;
import com.gthm.mapper.UserMapper;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GthmApplicationTests {


    @Autowired
    UserMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCases() throws JsonProcessingException {

        UserEntity userEntity = Instancio.create(UserEntity.class);

        System.out.println(userEntity);

        UserEntityDto dto = mapper.toDto(userEntity);

        System.out.println(new ObjectMapper().writeValueAsString(dto));


    }

}
