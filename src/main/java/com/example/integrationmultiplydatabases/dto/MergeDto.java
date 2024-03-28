package com.example.integrationmultiplydatabases.dto;

import com.example.integrationmultiplydatabases.model.mysql.nhanvien;
import com.example.integrationmultiplydatabases.model.sqlserver.NHANVIEN;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MergeDto {
    public Integer MANHANVIEN;

    public String HO;

    public String TEN;

    private String TENPHONGBAN;

    private double LUONGCOBAN;
}
