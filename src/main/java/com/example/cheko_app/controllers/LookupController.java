package com.example.cheko_app.controllers;

import com.example.cheko_app.dto.ApiResponse;
import com.example.cheko_app.services.LookupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("lookup")
public class LookupController {
    private final LookupService lookupService;

    @GetMapping("get-master-type")
    public ResponseEntity<?> getMasterType() {
        return ApiResponse.getSuccessResponse(lookupService.getMasterType());
    }

}
