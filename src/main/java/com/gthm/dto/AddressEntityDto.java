package com.gthm.dto;

import com.gthm.entity.Continent;
import com.gthm.entity.Country;
import lombok.*;

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