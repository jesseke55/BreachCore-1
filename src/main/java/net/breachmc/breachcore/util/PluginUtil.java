package net.breachmc.breachcore.util;

import net.breachmc.breachcore.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

/**
 * Copyright (c) 2015, Experminator.
 */
public class PluginUtil {

    private PluginUtil() {
    }

    public static void reload(ReloadType type) {
        switch (type) {
            case PLUGIN:
                Bukkit.getServer().getPluginManager().disablePlugin(Main.getPlugin());
                Bukkit.getServer().getPluginManager().enablePlugin(Main.getPlugin());
                break;
            case CONFIG:
                Main.getPlugin().reloadConfig();
                break;
            case ALL:
                Main.getPlugin().reloadConfig();
                Bukkit.getServer().getPluginManager().disablePlugin(Main.getPlugin());
                Bukkit.getServer().getPluginManager().enablePlugin(Main.getPlugin());
                break;
            default:
                throw new IllegalArgumentException("Invalid reload type.");
        }
    }

    public static void callEvent(Event event) {
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

    public enum ReloadType {

        PLUGIN,
        CONFIG,
        ALL;
    }
}
