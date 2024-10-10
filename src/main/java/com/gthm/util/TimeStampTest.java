package com.gthm.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeStampTest {


    public static void main(String[] args) {


        // Step 1: Get current ZonedDateTime with time zone "Asia/Kolkata"
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

        // Step 2: Convert the current time to ZonedDateTime using Instant and time zone
        ZonedDateTime event = ZonedDateTime.ofInstant(zonedDateTime.toInstant(), ZoneId.of("Asia/Kolkata"));

        // Step 3: Parse the comparison ZonedDateTime from string with zone offset
        ZonedDateTime compareValue = ZonedDateTime.parse("2019-05-21T04:19:39.791-05:00");

        // Step 4: Compare the two ZonedDateTime values
        System.out.println(event.compareTo(compareValue));


    }
}
