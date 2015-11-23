package net.breachmc.breachcore.command;

import org.bukkit.command.CommandSender;

/**
 * Copyright (c) 2015, Experminator.
 */
public interface SubCommand {

    void execute(CommandSender sender, String[] args);
}
