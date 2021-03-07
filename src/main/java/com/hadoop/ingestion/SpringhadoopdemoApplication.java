package com.hadoop.ingestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource({"classpath*:hadoop-config.xml"})
public class SpringhadoopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringhadoopdemoApplication.class, args);
    }

}
