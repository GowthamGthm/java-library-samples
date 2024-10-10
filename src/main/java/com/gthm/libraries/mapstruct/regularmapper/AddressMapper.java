package com.gthm.libraries.mapstruct.regularmapper;


import com.gthm.libraries.mapstruct.dto.AddressEntityDto;
import com.gthm.libraries.mapstruct.dto.ContactDetailsDto;
import com.gthm.libraries.mapstruct.dto.MobileDetailsDto;
import com.gthm.libraries.mapstruct.entity.AddressEntity;
import com.gthm.libraries.mapstruct.entity.ContactDetailsEntity;
import com.gthm.libraries.mapstruct.entity.Country;
import com.gthm.libraries.mapstruct.entity.MobileDetailsEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "country", target = "country", qualifiedByName = "mapStringToCountry")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntity toEntity(AddressEntityDto addressEntityDto);

    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToString")
    @Mapping(source = "contactDetailsEntity.mobileDetailsEntity" , target = "contactDetailsDto.mobileDetailsDto")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntityDto toDto(AddressEntity addressEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    MobileDetailsDto toDto(MobileDetailsEntity mobileDetailsEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    ContactDetailsDto toDto(ContactDetailsEntity contactDetailsEntity);


    // map ENUM
    @Named("mapCountryToString")
    default String mapCountryToString(Country country) {
        return country != null ? country.name() : null;
    }

    @Named("mapStringToCountry")
    default Country mapStringToCountry(String country) {
        return country != null ? Country.valueOf(country.toUpperCase()) : null;
    }



}