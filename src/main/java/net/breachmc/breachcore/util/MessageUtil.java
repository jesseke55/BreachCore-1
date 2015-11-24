package net.breachmc.breachcore.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Copyright (c) 2015, Experminator.
 */
public class MessageUtil {

    private MessageUtil() {
    }

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    /**
    * Send a message.
    *
    * @param target Console/Player to send a message to.
    * @param prefix With prefix or not.
    * @param message The message to send.
    */
    public static void send(CommandSender target, boolean prefix, String message) {
        target.sendMessage((prefix ? Main.getPrefix() : "") + color(message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(color(message));
    }
}
