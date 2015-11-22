package net.breachmc.breachcore.message;

import net.breachmc.breachcore.Main;
import org.bukkit.ChatColor;

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
}
