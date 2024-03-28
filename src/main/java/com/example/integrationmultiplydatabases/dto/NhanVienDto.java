package com.example.integrationmultiplydatabases.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;


//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
public interface NhanVienDto {
    public Integer getMANHANVIEN();
    public String getHO();
    public String getTEN();

    public String getTENPHONGBAN();
}
