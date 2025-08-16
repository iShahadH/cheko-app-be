package com.example.cheko_app.services;


import com.example.cheko_app.entities.MasterType;
import com.example.cheko_app.repositories.MasterTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LookupService {
    private final MasterTypeRepository masterTypeRepository;

    public List
            <MasterType> getMasterType() {
        return masterTypeRepository.findAll();
    }
}