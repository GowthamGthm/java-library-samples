package com.gthm.mapper;


import com.gthm.dto.AddressEntityDto;
import com.gthm.dto.UserEntityDto;
import com.gthm.entity.AddressEntity;
import com.gthm.entity.Country;
import com.gthm.entity.UserEntity;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "birthday" , target = "birthday" , qualifiedByName = "mapLocalDateToFutureIfNull")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    UserEntity toEntity(UserEntityDto userEntityDto);

    @Mapping(source = "birthday" , target = "birthday" , qualifiedByName = "mapLocalDateToFutureIfNull")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    UserEntityDto toDto(UserEntity userEntity);

    @Mapping(source = "country" , target = "country" , qualifiedByName = "mapStringToCountry")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntity toEntity(AddressEntityDto addressEntityDto);

    @Mapping(source = "country" , target = "country" , qualifiedByName = "mapCountryToString")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntityDto toDto(AddressEntity addressEntity);


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

//     default map for LocalDate
    @Named("mapLocalDateToFutureIfNull")
    default LocalDate mapLocalDate(LocalDate localDate) {
        return (localDate != null) ? localDate : LocalDate.now().plusYears(2);
    }

//     map list of enums
default List<Country> mapCountriesEnumToEnum(List<Country> countries) {
    return countries.stream()
                    .map(en -> en) // or any other conversion logic
                    .collect(Collectors.toList());
}

}