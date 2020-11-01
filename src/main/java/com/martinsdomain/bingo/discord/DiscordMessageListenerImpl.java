package com.martinsdomain.bingo.discord;

import com.martinsdomain.bingo.discord.handlers.UnknownMessageHandler;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DiscordMessageListenerImpl implements MessageListener {

    private static final String BINGO_REFERENCE = "!bingo";
    private static final MessageHandler UNKNOWN_MESSAGE_HANDLER = new UnknownMessageHandler();

    private final GatewayDiscordClient gatewayDiscordClient;
    private final MessageHandlerRegistry messageHandlerRegistry;

    @Autowired
    public DiscordMessageListenerImpl(
        GatewayDiscordClient gatewayDiscordClient,
        MessageHandlerRegistry messageHandlerRegistry
    ) {
        this.gatewayDiscordClient = gatewayDiscordClient;
        this.messageHandlerRegistry = messageHandlerRegistry;
    }

    @Override
    public void listen() {
        gatewayDiscordClient.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();

            if (message.getContent().startsWith(BINGO_REFERENCE)) {
                log.info("Message: {}", message.getContent());

                String[] tokens = message.getContent().split("\\s+");
                if (tokens.length > 1) {
                    String handlerName = tokens[1];
                    messageHandlerRegistry
                        .getRegistrations()
                        .getOrDefault(handlerName, UNKNOWN_MESSAGE_HANDLER)
                        .handle(message);
                }
            }
        });
    }
}
