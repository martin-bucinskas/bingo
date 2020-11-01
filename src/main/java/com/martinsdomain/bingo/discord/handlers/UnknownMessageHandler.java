package com.martinsdomain.bingo.discord.handlers;

import com.martinsdomain.bingo.discord.MessageHandler;
import com.martinsdomain.bingo.discord.MessageHandlerRegistration;
import discord4j.core.object.entity.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MessageHandlerRegistration(name = "help")
public class UnknownMessageHandler implements MessageHandler {

    @Override
    public void handle(Message message) {
        log.info("[help]: Received message: {}", message);
    }
}
