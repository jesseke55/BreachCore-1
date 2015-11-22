package net.breachmc.breachcore;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Main extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }
}
