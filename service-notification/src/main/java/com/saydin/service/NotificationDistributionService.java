package com.saydin.service;

import com.saydin.messaging.TicketNotification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationDistributionService {

    Logger logger=LoggerFactory.getLogger(NotificationDistributionService.class);

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println(ticketNotification);
        logger.info("Ticket Notification is :" +ticketNotification.toString());

    }
    //Bu servisi kuyruğu dinler ve ilgili yerlere dağıtır.
}
