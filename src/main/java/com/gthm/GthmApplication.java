package com.gthm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.gthm.libraries.mapstruct.dto.UserEntityDto;
import com.gthm.libraries.mapstruct.entity.UserEntity;
import com.gthm.libraries.mapstruct.regularmapper.UserMapper;
import org.instancio.Instancio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class GthmApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GthmApplication.class, args);
	}


	@Autowired
	UserMapper userMapper;

	@Override
	public void run(String... args) throws Exception {

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		List<UserEntityDto> list = IntStream.range(0, 10)
											.boxed()
											.map(e -> Instancio.create(UserEntity.class))
											.peek(e -> System.out.println(e))
											.map(e -> userMapper.toDto(e))
											.toList();

		System.out.println(mapper.writeValueAsString(list));

	}


}
