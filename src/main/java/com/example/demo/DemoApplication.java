package com.example.demo;

import io.awspring.cloud.sqs.listener.QueueNotFoundStrategy;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@SpringBootApplication
public class DemoApplication {
    //simulation https://github.com/awspring/spring-cloud-aws/issues/1052
	public static void main(String[] args) {

		System.out.println(System.getProperty("user.home"));
		SpringApplication.run(DemoApplication.class, args);
	}



	@Bean
	public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient) {
		return SqsTemplate.builder()
				.sqsAsyncClient(sqsAsyncClient)
				.configure(o -> o.queueNotFoundStrategy(QueueNotFoundStrategy.FAIL))
				.build();
	}
}
