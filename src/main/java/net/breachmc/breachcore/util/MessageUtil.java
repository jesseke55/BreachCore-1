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

    public static void send(CommandSender sender, boolean prefix, String message) {
        sender.sendMessage((prefix ? Main.getPrefix() : null) color(message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(color(message));
    }
}
