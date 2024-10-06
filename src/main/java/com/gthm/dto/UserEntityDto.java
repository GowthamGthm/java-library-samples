package com.gthm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gthm.entity.Country;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntityDto implements Serializable {

    private  String id;
    private  String name;
    private  AddressEntityDto address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private List<Country> visitedCountries;

    private String afterMappingField;
}