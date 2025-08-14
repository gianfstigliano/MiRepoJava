package org.f1.receptorasignador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.f1.receptorasignador.model")
public class ReceptorAsignadorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReceptorAsignadorApplication.class, args);}
}