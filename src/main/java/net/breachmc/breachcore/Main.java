package net.breachmc.breachcore;

import net.breachmc.breachcore.command.BroadcastCommand;
import net.breachmc.breachcore.command.CommandManager;
import net.breachmc.breachcore.command.ReloadCommand;
import net.breachmc.breachcore.util.MessageUtil;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Main extends JavaPlugin {

    private static JavaPlugin plugin;
    private static String prefix;

    @Override
    public void onEnable() {
        plugin = this;
        prefix = "&b&l[&6BreachCore&b&l]";

        getCommand("breachcore").setExecutor(new CommandManager());
        getCommand("breachcore").setTabCompleter(new CommandManager());

        CommandManager.addCommand(
                new ReloadCommand(),
                new BroadcastCommand()
        );
    }

    @Override
    public void onDisable() {
        plugin = null;
        prefix = null;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static String getPrefix() {
        return MessageUtil.color(prefix + "&r");
    }
}
