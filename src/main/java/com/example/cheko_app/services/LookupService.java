package com.example.cheko_app.services;


import com.example.cheko_app.dto.LookupDto;
import com.example.cheko_app.mapper.LookupMapper;
import com.example.cheko_app.repositories.MasterTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookupService {
    private final LookupMapper lookupMapper;
    private final MasterTypeRepository masterTypeRepository;

    public List
            <LookupDto> getMasterType() {
        return masterTypeRepository.findAll().stream().map(lookupMapper::mapMasterType).toList();
    }
}