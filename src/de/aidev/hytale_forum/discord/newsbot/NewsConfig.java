package de.aidev.hytale_forum.discord.newsbot;

import de.aidev.api.codecoreapi.core.commands.CommandExecuter;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;

public class NewsConfig implements CommandExecuter {

    @Override
    public boolean onCommand(Guild guild, String s, String[] strings, Member member, String s1, Message message) {
        if(member.hasPermission(Permission.ADMINISTRATOR) && message.getContentRaw().startsWith("!newschannel")){
            HytaleNewsBot.channel = message.getContentRaw().replace("!newschannel ","");
            message.delete().queue();
        }

        return true;
    }
}
