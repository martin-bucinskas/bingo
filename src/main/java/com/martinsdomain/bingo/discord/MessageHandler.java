package com.martinsdomain.bingo.discord;

import discord4j.core.object.entity.Message;

public interface MessageHandler {

    void handle(Message message);
}
