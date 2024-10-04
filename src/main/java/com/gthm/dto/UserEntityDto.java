package com.gthm.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntityDto implements Serializable {

    private  String id;
    private  String name;
    private  AddressEntityDto address;

}