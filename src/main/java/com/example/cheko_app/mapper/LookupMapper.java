package com.example.cheko_app.mapper;

import com.example.cheko_app.dto.LookupDto;
import com.example.cheko_app.entities.MasterType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LookupMapper {
    LookupDto mapMasterType(MasterType masterType);
}