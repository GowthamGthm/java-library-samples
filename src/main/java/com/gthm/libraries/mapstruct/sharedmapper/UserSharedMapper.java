package com.gthm.libraries.mapstruct.sharedmapper;

import com.gthm.libraries.mapstruct.dto.UserEntityDto;
import com.gthm.libraries.mapstruct.entity.UserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {CommonMapper.class})
public interface UserSharedMapper {

    @Mapping(source = "birthday", target = "birthday", qualifiedByName = "mapLocalDateToFutureIfNull")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    UserEntity toEntity(UserEntityDto userEntityDto);

    @Mapping(source = "birthday", target = "birthday", qualifiedByName = "mapLocalDateToFutureIfNull")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    UserEntityDto toDto(UserEntity userEntity);


}