package com.adekunle.awssimplenotificationserviceimplementation.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AmazonSNSConfig {


    @Value("${amazon.access.key}")
    private String accessKey;
    @Value("${amazon.secret.key}")
    private String secretKey;

    @Bean
    @Primary
    public AmazonSNSClient amazonSNSClient(){
        return (AmazonSNSClient)AmazonSNSClientBuilder
                .standard()
                .withRegion(Regions.US_GOV_EAST_1)  // region chosen on sns
                .withCredentials( new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey,secretKey)))
                .build();
    }
}
