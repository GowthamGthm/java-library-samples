package com.gthm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    private String id;
    private String name;

    private AddressEntity address;
    private LocalDate birthday;
    private List<Country> visitedCountries;

}
