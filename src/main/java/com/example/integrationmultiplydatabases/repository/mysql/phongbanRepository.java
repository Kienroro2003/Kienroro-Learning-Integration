package com.example.integrationmultiplydatabases.repository.mysql;

import com.example.integrationmultiplydatabases.model.mysql.phongban;
import org.springframework.data.jpa.repository.JpaRepository;

public interface phongbanRepository extends JpaRepository<phongban, Integer> {
}
