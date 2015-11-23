package net.breachmc.breachcore.util;

import org.bukkit.Bukkit;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Logger {

    private Logger() {
    }

    public static void log(LogType type, String msg) {
        switch (type) {
            case INFO:
                Bukkit.getLogger().info(msg);
                break;
            case WARNING:
                Bukkit.getLogger().warning(msg);
                break;
            case ERROR:
                Bukkit.getLogger().severe(msg);
                break;
            default:
                throw new IllegalArgumentException("Invalid log type.");
        }
    }

    public enum LogType {

        INFO, WARNING, ERROR;
    }
}
