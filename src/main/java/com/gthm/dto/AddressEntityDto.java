package com.gthm.dto;

import com.gthm.entity.Continent;
import com.gthm.entity.Country;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntityDto  {

    private  String street;
    private  String city;
    private  String state;
    private  Integer zip;

    private String country;
    private Continent continent;


}