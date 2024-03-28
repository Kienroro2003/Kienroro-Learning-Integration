package com.example.integrationmultiplydatabases.repository.mysql;

import com.example.integrationmultiplydatabases.dto.BangLuongNhanVienViewModel;
import com.example.integrationmultiplydatabases.dto.MergeDto;
import com.example.integrationmultiplydatabases.dto.NhanVienDto;
import com.example.integrationmultiplydatabases.model.mysql.nhanvien;
import com.example.integrationmultiplydatabases.model.sqlserver.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface nhanvienRepository extends JpaRepository<nhanvien, Integer> {
    @Query("SELECT a FROM nhanvien a JOIN FETCH a.phongban")
    List<nhanvien> fetchAll();
}
