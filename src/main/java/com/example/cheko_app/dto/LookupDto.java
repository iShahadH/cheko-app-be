package com.example.cheko_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LookupDto {

    private Long id;
    private String nameAr;
    private String nameEn;

}