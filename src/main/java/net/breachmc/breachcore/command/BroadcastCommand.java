package net.breachmc.breachcore.command;

import net.breachmc.breachcore.message.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2015, Experminator.
 */
public class BroadcastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            MessageManager.getMessage("only-players").send(sender);
            return true;
        }

        if (args.length == 0) {
            MessageManager.getMessage("not-enough-arguments").send(sender);
            return true;
        } else {
            String msg = "";

            for (int i = 0; i < args.length; i++) {
                msg += args[i] = " ";
            }

            msg = msg.trim();
            msg = msg.replace(msg.charAt(0), Character.toUpperCase(msg.charAt(0)));

            Bukkit.broadcastMessage(MessageManager.toColor(msg));
            return true;
        }
    }
}
