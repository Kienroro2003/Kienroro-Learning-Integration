package com.example.integrationmultiplydatabases.model.mysql;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;


@Table(name = "nhanvien")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class nhanvien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MANHANVIEN")
    private Integer MANHANVIEN;

    @Column(name = "DIACHI")
    private String DIACHI;

    @Column(name = "GIOITINH")
    private boolean GIOITINH;

    @Column(name = "HO")
    private String HO;

    @Column(name = "NGAYSINH")
    private Date NGAYSINH;

    @Column(name = "TEN")
    private String TEN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAPHONGBAN")
    private phongban phongban;
}
