package com.forUMC;


import com.forUMC.domain.Review;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Umc6thMissionApplication {

    public static void main(String[] args) {
        SpringApplication.run(Umc6thMissionApplication.class, args);

        //Example

    }

}
