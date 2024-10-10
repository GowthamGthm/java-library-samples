package com.gthm.libraries.mapstruct.dto;

import com.gthm.libraries.mapstruct.entity.ContactDetailsEntity;
import com.gthm.libraries.mapstruct.entity.Continent;
import com.gthm.libraries.mapstruct.entity.MobileDetailsEntity;
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

    private ContactDetailsDto contactDetailsDto;


}