package com.gthm.libraries.mapstruct.sharedmapper;

import com.gthm.libraries.mapstruct.dto.AddressEntityDto;
import com.gthm.libraries.mapstruct.dto.ContactDetailsDto;
import com.gthm.libraries.mapstruct.dto.MobileDetailsDto;
import com.gthm.libraries.mapstruct.entity.AddressEntity;
import com.gthm.libraries.mapstruct.entity.ContactDetailsEntity;
import com.gthm.libraries.mapstruct.entity.MobileDetailsEntity;
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
    @Mapping(source = "contactDetailsEntity.mobileDetailsEntity" , target = "contactDetailsDto.mobileDetailsDto")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    AddressEntityDto toDto(AddressEntity addressEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    MobileDetailsDto toDto(MobileDetailsEntity mobileDetailsEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    ContactDetailsDto toDto(ContactDetailsEntity contactDetailsEntity);

}