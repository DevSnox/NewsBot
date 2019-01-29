package de.aidev.hytale_forum.discord.newsbot;

import de.aidev.api.codecoreapi.core.commands.CommandExecuter;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;

import java.awt.*;

public class NewsPaperCommand implements CommandExecuter {

    @Override
    public boolean onCommand(Guild guild, String s, String[] strings, Member member, String s1, Message message) {
        User user = message.getAuthor();
        Member memberr = guild.getMember(user);

        String[] args = message.getContentRaw().split(" ");

        if(memberr.hasPermission(Permission.ADMINISTRATOR)){
            if(message.getContentRaw().startsWith("!newspaper")){
                System.out.println(HytaleNewsBot.channel);
                TextChannel channel = guild.getTextChannelsByName(HytaleNewsBot.channel,true).get(0);
                EmbedBuilder eb = new EmbedBuilder();

                eb.setTitle(args[1]);
                eb.setColor(Color.RED);

                String restApi = message.getContentRaw().replace("!newspaper " , "").replace(args[1] + " ","");

                eb.addField("",restApi,false);

                channel.sendMessage(eb.build()).queue();

                message.delete().queue();

            }
        }

        return false;
    }
}
