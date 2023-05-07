package com.example.backend_app_movil.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3Config {

    @Bean
    public S3Client s3ClientConfigLocal(
    ) {

        return S3Client.builder().region(Region.US_EAST_1).build();
    }

}
