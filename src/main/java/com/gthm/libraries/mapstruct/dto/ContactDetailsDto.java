package com.gthm.libraries.mapstruct.dto;


import com.gthm.libraries.mapstruct.entity.MobileDetailsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactDetailsDto {

    private MobileDetailsDto mobileDetailsDto;

}