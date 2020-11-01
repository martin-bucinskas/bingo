package com.martinsdomain.bingo.discord;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public interface MessageListener {

    @EventListener(ApplicationReadyEvent.class)
    void listen();
}
