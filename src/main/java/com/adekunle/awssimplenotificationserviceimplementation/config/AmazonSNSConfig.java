package com.adekunle.awssimplenotificationserviceimplementation.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.amazonaws.services.ec2.model.Scope.Region;

@Configuration
public class AmazonSNSConfig {
    @Bean
    public AmazonSNSClient amazonSNSClient(){
        return AmazonSNSClientBuilder
                .standard()
                .withRegion(Regions.US_GOV_EAST_1)
                .withCredentials( new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                        "",""
                )));
    }
}
