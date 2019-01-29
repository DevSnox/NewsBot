package de.aidev.hytale_forum.discord.newsbot;

import de.aidev.api.codecoreapi.main.CodeCoreAPI;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.Permission;

import javax.security.auth.login.LoginException;

public class HytaleNewsBot {
    public static String channel = "general";
    public static void main(String[] args){
        try{
            CodeCoreAPI bot = new CodeCoreAPI();

            bot.getJDA().setAutoReconnect(true);

            bot.start("NewsBot", OnlineStatus.IDLE);

            bot.addCommand(new NewsPaperCommand(), "!newspaper", Permission.ADMINISTRATOR);
            bot.addCommand(new NewsConfig(), "!newschannel",Permission.ADMINISTRATOR);
        }catch (LoginException exception){
            System.out.println("LOGINEXCEPTION : False token or network error.");
            exception.printStackTrace();
        }
    }
}
