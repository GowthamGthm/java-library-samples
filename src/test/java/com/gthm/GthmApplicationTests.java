package com.gthm;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gthm.dto.UserEntityDto;
import com.gthm.entity.UserEntity;
import com.gthm.mapper.UserMapper;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class GthmApplicationTests {

    @Autowired
    UserMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCases() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        UserEntity userEntity = Instancio.create(UserEntity.class);

        userEntity.setId(null);
        userEntity.setBirthday(null);

        System.out.println(userEntity);
        UserEntityDto dto = mapper.toDto(userEntity);
        System.out.println(objectMapper.writeValueAsString(dto));

        assertThat(Integer.valueOf(dto.getBirthday().getYear())).isEqualTo(LocalDate.now().plusYears(2).getYear());
        assertThat(dto.getId()).isEmpty();


    }

}