package com.gthm.controller;


import com.gthm.libraries.mapstruct.dto.UserEntityDto;
import com.gthm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        try {
            List<UserEntityDto> run = testService.run();
            return ResponseEntity.status(HttpStatus.OK).body(run);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/test1")
    public String test1() {
        return "TEST1 WORKED";
    }

}