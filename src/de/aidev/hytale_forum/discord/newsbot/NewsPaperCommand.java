package de.aidev.hytale_forum.discord.newsbot;

import de.aidev.api.codecoreapi.core.commands.CommandExecuter;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.awt.*;

public class NewsPaperCommand implements CommandExecuter {

    @Override
    public boolean onCommand(Guild guild, String s, String[] strings, Member member, String s1, Message message) {
        
        String[] args = message.getContentRaw().split(" ");

        if(member.hasPermission(Permission.ADMINISTRATOR) && message.getContentRaw().startsWith("!newspaper")) {
            TextChannel channel = guild.getTextChannelsByName(HytaleNewsBot.channel,true).get(0);
            EmbedBuilder eb = new EmbedBuilder();

            eb.setTitle(args[1]);
            eb.setColor(Color.RED);

            String restApi = message.getContentRaw().replace("!newspaper " , "").replace(args[1] + " ","");

            eb.addField("",restApi,false);

            channel.sendMessage(eb.build()).queue();
            
            message.delete().queue();
        }

        return false;
    }
}
