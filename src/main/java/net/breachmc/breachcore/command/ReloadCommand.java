package net.breachmc.breachcore.command;

import net.breachmc.breachcore.Main;
import net.breachmc.breachcore.util.MessageUtil;
import net.breachmc.breachcore.util.PluginUtil;
import org.bukkit.command.CommandSender;

/**
 * Copyright (c) 2015, Experminator.
 */
@CommandData(
        name = "Reload",
        description = "Reload the plugin",
        aliases = {"rl", "load"},
        permission = "breachcore.reload",
        isOnlyPlayer = false
)
public class ReloadCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("plugin")) {
                PluginUtil.reload(PluginUtil.ReloadType.PLUGIN);
                MessageUtil.send(sender, Main.getPrefix() + "&aPlugin is successfully reloaded.");
            } else if (args[0].equalsIgnoreCase("config")) {
                PluginUtil.reload(PluginUtil.ReloadType.CONFIG);
                MessageUtil.send(sender, Main.getPrefix() + "&aConfiguration is successfully reloaded.");
            }
        } else {
            PluginUtil.reload(PluginUtil.ReloadType.ALL);
            MessageUtil.send(sender, Main.getPrefix() + "&aPlugin & Configuration is successfully reloaded.");
        }
    }
}
