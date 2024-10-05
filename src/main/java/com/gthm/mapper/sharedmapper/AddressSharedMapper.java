package com.gthm.mapper.sharedmapper;

import com.gthm.dto.AddressEntityDto;
import com.gthm.entity.AddressEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public interface AddressSharedMapper {

    @Mapping(source = "country", target = "country", qualifiedByName = "mapStringToCountry")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntity toEntity(AddressEntityDto addressEntityDto);

    @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToString")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntityDto toDto(AddressEntity addressEntity);



}