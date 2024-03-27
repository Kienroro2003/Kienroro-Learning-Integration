package com.example.integrationmultiplydatabases.model.sqlserver;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.util.Date;

@Table(name = "NHANVIEN")
@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NHANVIEN {
    @Id
    @Column(name = "MANHANVIEN")
    private int MANHANVIEN;
    @Column(name = "HO")
    private String HO;
    @Column(name = "TEN")
    private String TEN;
    @Column(name = "NGAYSINH")
    private Date NGAYSINH;
}
