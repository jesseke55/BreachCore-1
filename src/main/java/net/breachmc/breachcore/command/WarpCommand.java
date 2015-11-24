package net.breachmc.breachcore.command;

import net.breachmc.breachcore.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Copyright (c) 2015, Experminator.
 */
@CommandData(
        name = "warp",
        description = "Go to a warp",
        aliases = {"ewarp", "warps", "ewarps", "listwarp", "warplist"},
        permission = "breach.cmd.warp",
        isOnlyPlayer = true
)
public class WarpCommand implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
    
        Player p = (Player) sender;
        if (args.length == 0) {
            p.openInventory(new Menus().Warp());
            return;
        }
    }
}
