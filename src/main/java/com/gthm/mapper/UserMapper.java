package com.gthm.mapper;


import com.gthm.dto.AddressEntityDto;
import com.gthm.dto.UserEntityDto;
import com.gthm.entity.AddressEntity;
import com.gthm.entity.Country;
import com.gthm.entity.UserEntity;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    UserEntity toEntity(UserEntityDto userEntityDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    UserEntityDto toDto(UserEntity userEntity);

    @Mapping(source = "country" , target = "country" , qualifiedByName = "mapStringToCountry")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntity toEntity(AddressEntityDto addressEntityDto);

    @Mapping(source = "country" , target = "country" , qualifiedByName = "mapCountryToString")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntityDto toDto(AddressEntity addressEntity);


    default LocalDate mapLocalDate(LocalDate date) {
        return date == null ? LocalDate.now()
                                       .plusYears(10) : date;
    }

    default String mapString(String value) {
        return value == null ? "" : value;
    }

    default Float mapFloat(Float value) {
        return value == null ? 0f : value;
    }

    default BigDecimal mapBigDecimal(BigDecimal value) {
        return value == null ? BigDecimal.ZERO : value;
    }

    default Boolean mapBoolean(Boolean value) {
        return value == null ? false : value;
    }


    default Integer mapInteger(Integer value) {
        return value == null ? 0 : value;
    }

    //     map ENUM
    @Named("mapCountryToString")
    default String mapCountryToString(Country country) {
        return country != null ? country.name() : null;
    }

    @Named("mapStringToCountry")
    default Country mapStringToCountry(String country) {
        return country != null ? Country.valueOf(country.toUpperCase()) : null;
    }



}