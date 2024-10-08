package com.gthm.util;

import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.StackSize;
import com.gthm.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.instancio.Instancio;

import java.util.Random;
import java.util.logging.Level;

@Slf4j
public class FloggerTest {
    static FluentLogger fluentLogger = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
        System.setProperty("flogger.logging.level", "INFO");

        fluentLogger.atInfo()
                    .log("I'm from %s , Always an %s , My AGE is: %s", "india", "INDIAN", 20);

        fluentLogger.at(Level.SEVERE)
                    .log("I'm from %s , Always an %s , My AGE is: %s", "india", "INDIAN", 25);


       generateException();

        UserEntity userEntity = Instancio.create(UserEntity.class);

        fluentLogger.atInfo()
                .log("Logged in user details: %s " , userEntity);



    }

    private static void generateException() {

        String abc = null;

        try {
//            String lowerCase = abc.toLowerCase();

            for(int i = 0; i< 100; i++) {
                int divisor = new Random().nextInt(500) % 2;
                System.out.println("dividing by: " + divisor);
                Long result = 10L / divisor;
            }

        } catch (Exception e ) {
            fluentLogger.atSevere().withStackTrace(StackSize.FULL)
                        .withCause(e).log("Error occurred: %s", e.getMessage());
        }

    }
}