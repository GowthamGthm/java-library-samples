package com.gthm.libraries.mapstruct.entity;


import com.gthm.libraries.mapstruct.dto.ContactDetailsDto;
import com.gthm.libraries.mapstruct.dto.MobileDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {

    private String street;
    private String city;
    private String state;
    private Integer zip;

    private Country country;
    private Continent continent;

    private ContactDetailsEntity contactDetailsEntity;

}