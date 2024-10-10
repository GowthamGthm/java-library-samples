package com.gthm.libraries.mapstruct.sharedmapper;

import com.gthm.libraries.mapstruct.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CommonMapper {


    default String mapString(String value) {
        return value == null ? "ABCD" : value;
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

    // map ENUM
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
        return (localDate != null) ? localDate : LocalDate.now()
                                                          .plusYears(2);
    }

    //     map list of enums
    default List<Country> mapCountriesEnumToEnum(List<Country> countries) {
        return countries.stream()
                        .map(en -> en) // or any other conversion logic
                        .collect(Collectors.toList());
    }

}
