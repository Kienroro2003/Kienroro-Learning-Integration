package com.example.integrationmultiplydatabases;

import com.example.integrationmultiplydatabases.repository.mysql.nhanvienRepository;
//import com.example.integrationmultiplydatabases.repository.mysql.phongbanRepository;
import com.example.integrationmultiplydatabases.repository.mysql.phongbanRepository;
import com.example.integrationmultiplydatabases.repository.sqlserver.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@AllArgsConstructor
public class IntegrationmultiplydatabasesApplication {
//    private final EmployeeRepository employeeRepository;
    private final nhanvienRepository nhanvienRepository;
    private final phongbanRepository phongbanRepository;

    public static void main(String[] args) {
        SpringApplication.run(IntegrationmultiplydatabasesApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
//			employeeRepository.findAll().forEach(System.out::println);
//            nhanvienRepository.findAll().forEach(item ->{
//                System.out.println(item + ", " + item.getPhongban());
//            });
            System.out.println(nhanvienRepository.fetchByName(1).getPhongban().getTENPHONGBAN());
        };
    }
}
