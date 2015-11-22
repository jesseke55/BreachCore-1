package net.breachmc.breachcore.message;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Message {

    private char colorChar;
    private String key;
    private String value;

    public Message(char colorChar, String key, String value) {
        this.colorChar = colorChar;
        this.key = key;
        this.value = value;
    }

    public Message(String key, String value) {
        this('&', key, value);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void send(CommandSender... players) {
        for (CommandSender p : players) {
            p.sendMessage(ChatColor.translateAlternateColorCodes(colorChar, value));
        }
    }
}
