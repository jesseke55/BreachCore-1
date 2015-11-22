package net.breachmc.breachcore.command;

import net.breachmc.breachcore.Main;
import net.breachmc.breachcore.message.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Copyright (c) 2015, Experminator.
 */
public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("breach.reload")) {
            Main.reload((args.length == 1 && (args[0].equalsIgnoreCase("plugin") || args[0].equalsIgnoreCase("-p")));
            MessageManager.getMessage("reload-complete").send(sender);
            return true;
        }

        return false;
    }
}
