package hr.tvz.ivankovic.hardwareapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class HardwareappApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardwareappApplication.class, args);
    }

}
