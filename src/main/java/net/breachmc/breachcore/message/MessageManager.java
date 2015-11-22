package net.breachmc.breachcore.message;

import net.breachmc.breachcore.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Copyright (c) 2015, Experminator.
 */
public class MessageManager {

    private static char colorChar = '&';

    private MessageManager() {
    }

    public static String getMessageAsString(String key) {
        return Main.getMessages().<String>get(key);
    }

    public static Message getMessage(String key) {
        return new Message(key, Main.getMessages().<String>get(key));
    }

    public static boolean hasMessage(String key) {
        return Main.getMessages().contains(key);
    }

    public static void setMessage(String key, String value) {
        if (value != null) {
            Main.getMessages().set(key, value);
            Main.getMessages().save();
        } else {
            Main.getMessages().remove(key);
            Main.getMessages().save();
        }
    }

    public static void addMessage(Message message) {
        MessageManager.setMessage(message.getKey(), message.getValue());
    }

    public static void addAllMessages(Message... messages) {
        for (Message message : messages) {
            MessageManager.addMessage(message);
        }
    }

    public static String toColor(String msg) {
        return ChatColor.translateAlternateColorCodes(MessageManager.colorChar, msg);
    }

    public static char getColorChar() {
        return colorChar;
    }

    public static void setColorChar(char colorChar) {
        MessageManager.colorChar = colorChar;
    }

    public static class Message {

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
}
