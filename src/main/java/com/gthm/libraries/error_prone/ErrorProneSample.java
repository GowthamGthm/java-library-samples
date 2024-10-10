package com.gthm.libraries.error_prone;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ErrorProneSample {

    public static void main(String[] args) throws JsonProcessingException {

        String abcd = null;
        //  error prone , would throw compile time error for the line 15,
        //  as the return value is not used
        String lowerCase = abcd.toLowerCase();

    }

}