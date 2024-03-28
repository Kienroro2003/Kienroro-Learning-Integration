package com.example.integrationmultiplydatabases;

import com.example.integrationmultiplydatabases.dto.MergeDto;
import com.example.integrationmultiplydatabases.model.mysql.nhanvien;
import com.example.integrationmultiplydatabases.model.sqlserver.NHANVIEN;
import com.example.integrationmultiplydatabases.repository.mysql.nhanvienRepository;
//import com.example.integrationmultiplydatabases.repository.mysql.phongbanRepository;
import com.example.integrationmultiplydatabases.repository.mysql.phongbanRepository;
import com.example.integrationmultiplydatabases.repository.sqlserver.NHANVIENRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@AllArgsConstructor
public class IntegrationmultiplydatabasesApplication {
    //    private final EmployeeRepository employeeRepository;
    private final nhanvienRepository nhanvienRepository;
    private final phongbanRepository phongbanRepository;
    private final NHANVIENRepository NHANVIENRepository;

    public static void main(String[] args) {
        SpringApplication.run(IntegrationmultiplydatabasesApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            List<NHANVIEN> NHANVIENList = NHANVIENRepository.fetchAll();
            List<nhanvien> nhanvienList = nhanvienRepository.fetchAll();
            List<MergeDto> mergeDtoList = NHANVIENList.stream()
                    .flatMap(
                    table1 -> nhanvienList.stream()
                    .filter(table2-> table1.getMANHANVIEN() == table2.getMANHANVIEN())
                    .map(table2 -> new MergeDto(table2.getMANHANVIEN(),
                            table2.getHO(),
                            table2.getTEN(),
                            table2.getPhongban().getTENPHONGBAN(),
                            table1.getLuongs().get(0).getLUONGCOBAN())))
                    .toList();
            mergeDtoList.forEach(System.out::println);

        };
    }
}
