package com.martinsdomain.bingo.configuration;

import com.martinsdomain.bingo.discord.MessageHandlerRegistry;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class DiscordConfiguration {

    private final String discordToken;

    public DiscordConfiguration(
        @Value("${discord.token}") String discordToken
    ) {
        this.discordToken = discordToken;
    }

    @Bean
    DiscordClient discordClient() {
        return DiscordClient.create(discordToken);
    }

    @Bean
    GatewayDiscordClient gatewayDiscordClient(DiscordClient discordClient) {
        return discordClient.login().block();
    }

    @Bean
    MessageHandlerRegistry messageHandlerRegistry() {
        MessageHandlerRegistry messageHandlerRegistry = new MessageHandlerRegistry();
        messageHandlerRegistry.registerHandlers();

        return messageHandlerRegistry;
    }
}
