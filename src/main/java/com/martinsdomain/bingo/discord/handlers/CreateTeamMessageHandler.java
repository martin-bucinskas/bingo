package com.martinsdomain.bingo.discord.handlers;

import com.martinsdomain.bingo.discord.MessageHandler;
import com.martinsdomain.bingo.discord.MessageHandlerRegistration;
import discord4j.core.object.entity.Message;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@MessageHandlerRegistration(name = "create-team")
public class CreateTeamMessageHandler implements MessageHandler {

    @Override
    public void handle(Message message) {
        log.info("[create-team]: Received message: {}", message);

        String id = message.getAuthor().orElse(null).getId().asString();
        String username = message.getAuthor().orElse(null).getUsername();
        String discriminator = message.getAuthor().orElse(null).getDiscriminator();

        log.info("ID: {}", id);
        log.info("Username: {}", username);
        log.info("Discriminator: {}", discriminator);

        Objects.requireNonNull(
            message.getChannel().block()
        ).createMessage("Hello world").block();

        // TODO: Do the logic to handle creating a team
        // TODO: Extract team name from request, do some validations - JSR303 validations?
        // TODO: Store the team in database - along with metadata, etc.
    }
}
