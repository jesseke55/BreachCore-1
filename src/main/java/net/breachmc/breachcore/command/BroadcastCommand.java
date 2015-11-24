package net.breachmc.breachcore.command;

import net.breachmc.breachcore.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2015, Experminator.
 */
@CommandData(
        name = "Broadcast",
        description = "Broadcast a message",
        aliases = {"bc", "alert", "say", "notice"},
        permission = "breachcore.broadcast",
        isOnlyPlayer = false
)
public class BroadcastCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            MessageUtil.send(sender, "&cYou need to specify a message.");
            return;
        } else {
            String msg = "";

            for (String arg : args) {
                msg += arg + " ";
            }

            msg = msg.trim();
            msg = msg.replace(msg.charAt(0), Character.toUpperCase(msg.charAt(0)));

            for (Player on : Bukkit.getOnlinePlayers()) {
                msg = msg.replace("%name%", on.getName());
                msg = msg.replace("%nick%", on.getDisplayName());
                msg = msg.replace("%time%", Long.toString(on.getWorld().getTime()));
                msg = msg.replace("%ip%", Bukkit.getServer().getIp());
                msg = msg.replace("%port%", Integer.toString(Bukkit.getServer().getPort()));
                msg = msg.replace("%version%", Bukkit.getServer().getBukkitVersion());
                msg = msg.replace("%sender%", sender.getName());

                MessageUtil.broadcast(msg);
            }
        }
    }
}
