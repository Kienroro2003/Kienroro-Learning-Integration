package com.example.integrationmultiplydatabases.repository.sqlserver;


import com.example.integrationmultiplydatabases.model.sqlserver.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<NHANVIEN,Integer> {
}
