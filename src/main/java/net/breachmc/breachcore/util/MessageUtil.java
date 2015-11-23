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

    public static void send(CommandSender sender, String message) {
        sender.sendMessage(color(message));
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(color(message));
    }
}
