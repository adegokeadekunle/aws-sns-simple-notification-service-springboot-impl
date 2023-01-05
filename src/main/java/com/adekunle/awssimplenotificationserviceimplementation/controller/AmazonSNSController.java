package com.adekunle.awssimplenotificationserviceimplementation.controller;


import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AmazonSNSController {
    
    private final AmazonSNSClient amazonSNSClient;

    private String TOPIC_ARN = ""; //TOPIC_ARN gotten from the Amazon SNS

    @GetMapping("/subscribe/{email}")
    public String subscribeToSNSTopic(@PathVariable("email")String email){
        SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN,"email",email);
        amazonSNSClient.subscribe(subscribeRequest);

        return "a message has been sent to your email";
    }

    @GetMapping("/publish/{message}")
    public String publishToSNSTopic(@PathVariable("message") String message){
        PublishRequest publishRequest = new PublishRequest(TOPIC_ARN, "SNS message in springboot");
        amazonSNSClient.publish(publishRequest);

        return "message published";
    }
}
