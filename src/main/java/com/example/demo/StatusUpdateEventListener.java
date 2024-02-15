package com.example.demo;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class StatusUpdateEventListener {

    @SqsListener("${epf.status-update.messaging.queue}")
    public void processStatusUpdate(String jsonMessage){

    }
}
