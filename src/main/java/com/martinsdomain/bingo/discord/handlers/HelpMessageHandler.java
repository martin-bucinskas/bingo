package com.martinsdomain.bingo.discord.handlers;

import com.martinsdomain.bingo.discord.MessageHandler;
import com.martinsdomain.bingo.discord.MessageHandlerRegistration;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

@MessageHandlerRegistration(name = "help")
public class HelpMessageHandler implements MessageHandler {

    private static final String CREATE_TEAM_HELP_MESSAGE = "`!bingo create-team <team-name>`\nCreates a team\n";
    private static final String ADD_USER_TO_TEAM_MESSAGE = "`!bingo team-add <team-name> <discord-user-name>`\nAdds player to team\n";
    private static final String REMOVE_USER_FROM_TEAM_MESSAGE = "`!bingo team-remove <team-name> <discord-user-name>`\nRemoves player from team\n";

    @Override
    public void handle(Message message) {
        MessageChannel channel = message.getChannel().block();

        if (channel != null) {
            channel.createMessage(buildHelpMessage()).block();
        }
    }

    private String buildHelpMessage() {

        return CREATE_TEAM_HELP_MESSAGE +
        ADD_USER_TO_TEAM_MESSAGE +
        REMOVE_USER_FROM_TEAM_MESSAGE;
    }
}
