package net.breachmc.breachcore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright (c) 2015, Experminator.
 */
public class CommandManager implements CommandExecutor, TabCompleter {

    private static Set<SubCommand> subCommands = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        final List<String> list = new ArrayList<>();

        for (SubCommand sc : subCommands) {
            if (sc.getClass().getAnnotation(CommandData.class) != null) {
                CommandData data = sc.getClass().getAnnotation(CommandData.class);

                list.add(data.name());
            }
        }

        return list;
    }

    public static Set<SubCommand> getSubCommands() {
        return subCommands;
    }

    public static SubCommand getCommand(String name) {
        for (SubCommand sc : subCommands) {
            if (sc.getClass().getAnnotation(CommandData.class) != null) {
                CommandData data = sc.getClass().getAnnotation(CommandData.class);

                for (String alias : data.aliases()) {
                    if (data.name().equalsIgnoreCase(name) || alias.equalsIgnoreCase(name)) {
                        return sc;
                    }
                }
            }
        }

        return null;
    }
}
