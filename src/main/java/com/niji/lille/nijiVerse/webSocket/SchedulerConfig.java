package com.niji.lille.nijiVerse.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class SchedulerConfig {

    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 10000)
    public void sendAdhocMessages(){
        template.convertAndSend("/topic/user", new ParkingResponse("Fixed Delay Scheduler"));
    }
}
