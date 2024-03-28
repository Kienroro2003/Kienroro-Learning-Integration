package com.example.integrationmultiplydatabases.repository.sqlserver;


import com.example.integrationmultiplydatabases.model.mysql.nhanvien;
import com.example.integrationmultiplydatabases.model.sqlserver.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NHANVIENRepository extends JpaRepository<NHANVIEN,Integer> {
    @Query("SELECT a FROM NHANVIEN a JOIN FETCH a.luongs")
    List<NHANVIEN> fetchAll();
}
