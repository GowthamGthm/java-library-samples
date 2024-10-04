package com.gthm.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntityDto implements Serializable {

    private  String id;
    private  String name;
    private  AddressEntityDto address;

    LocalDate birthday;

}