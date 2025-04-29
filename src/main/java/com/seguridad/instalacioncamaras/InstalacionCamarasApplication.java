package com.instalacioncamaras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.instalacioncamaras.repository")
public class InstalacionCamarasApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstalacionCamarasApplication.class, args);
    }
}
