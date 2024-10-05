package com.gthm.mapper;


import com.gthm.dto.AddressEntityDto;
import com.gthm.entity.AddressEntity;
import com.gthm.entity.Country;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "country", target = "country", qualifiedByName = "mapStringToCountry")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntity toEntity(AddressEntityDto addressEntityDto);

    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToString")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntityDto toDto(AddressEntity addressEntity);


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