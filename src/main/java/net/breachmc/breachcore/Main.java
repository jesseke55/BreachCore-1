package net.breachmc.breachcore;

import net.breachmc.breachcore.command.CommandManager;
import net.breachmc.breachcore.configuration.ConfigurationManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Main extends JavaPlugin {

    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        getCommand("breachcore").setExecutor(new CommandManager());
        getCommand("breachcore").setTabCompleter(new CommandManager());
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    public static void reload(boolean plugin) {
        Main.getPlugin().reloadConfig();

        if (plugin) {
            Bukkit.getServer().getPluginManager().disablePlugin(Main.getPlugin());
            Bukkit.getServer().getPluginManager().enablePlugin(Main.getPlugin());
        }
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static ConfigurationManager getConfiguration() {
        return new ConfigurationManager("config", ConfigurationManager.FileType.YAML);
    }

    public static ConfigurationManager getMessages() {
        return new ConfigurationManager("messages", ConfigurationManager.FileType.YAML);
    }
}
