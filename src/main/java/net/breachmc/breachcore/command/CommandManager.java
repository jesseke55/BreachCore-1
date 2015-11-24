package net.breachmc.breachcore.command;

import net.breachmc.breachcore.util.MessageUtil;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.*;

/**
 * Copyright (c) 2015, Experminator.
 */
public class CommandManager implements CommandExecutor, TabCompleter {

    private static final Map<String, SubCommand> subCommands = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("breachcore")) {
            if (args.length == 0) {
                for (SubCommand sc : subCommands.values()) {
                    if (hasCommandData(sc)) {
                        CommandData data = getCommandData(sc);

                        if (sender.hasPermission(data.permission())) {
                            MessageUtil.send(sender, false, "&6{name} ({aliases})&7: {description}"
                                            .replace("{name}", data.name())
                                            .replace("{aliases}", String.join("|", data.aliases()))
                                            .replace("{description}", data.description())
                            );
                        }
                    }
                }

                return true;
            }

            SubCommand target = getCommand(args[0]);

            if (target == null) {
                MessageUtil.send(sender, true, "&cCommand '{name}' does not exists.".replace("{name}", args[0]));
                return true;
            }

            if (!hasCommandData(target)) {
                MessageUtil.send(sender, true, "&cCommand '{name}' is not correctly configured.".replace("{name}", args[0]));
                return true;
            }

            CommandData data = getCommandData(target);

            if (data.isOnlyPlayer() && !(sender instanceof Player)) {
                MessageUtil.send(sender, true, "&cCommand '{name}' can only be used by players.".replace("{name}", data.name()));
                return true;
            }

            if (!sender.hasPermission(data.permission()) || !sender.isOp()) {
                MessageUtil.send(sender, true, "&cYou don't have permission to use the command '{name}'.".replace("{name}", data.name()));
                return true;
            }

            List<String> newArgs = Arrays.asList(args);
            newArgs.remove(0);
            args = newArgs.toArray(new String[newArgs.size()]);

            if (sender instanceof Player) {
                target.execute((Player) sender, args);
                return true;
            } else {
                target.execute((ConsoleCommandSender) sender, args);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cnd, String label, String[] args) {
        List<String> result = new ArrayList<>();

        for (SubCommand sc : subCommands.values()) {
            if (hasCommandData(sc)) {
                result.add(getCommandData(sc).name());
            }
        }

        return result;
    }

    public static Collection<SubCommand> getCommands() {
        return subCommands.values();
    }

    public static SubCommand getCommand(String name) {
        for (SubCommand sc : subCommands.values()) {
            if (hasCommandData(sc)) {
                CommandData data = getCommandData(sc);

                for (String alias : data.aliases()) {
                    if (data.name().equalsIgnoreCase(name) || alias.equalsIgnoreCase(name)) {
                        return sc;
                    }
                }
            }
        }

        return null;
    }

    public static boolean hasCommandData(final SubCommand subCommand) {
        return getCommandData(subCommand) != null;
    }

    public static CommandData getCommandData(final SubCommand subCommand) {
        return subCommand.getClass().getDeclaredAnnotation(CommandData.class);
    }

    public static boolean addCommand(final SubCommand... subCommands) {
        for (SubCommand subCommand : subCommands) {
            if (hasCommandData(subCommand)) {
                CommandManager.subCommands.put(getCommandData(subCommand).name(), subCommand);
                return true;
            }
        }

        return false;
    }

    public static boolean removeCommand(final SubCommand subCommand) {
        for (SubCommand sc : subCommands.values()) {
            if (sc.equals(subCommand)) {
                if (hasCommandData(sc)) {
                    subCommands.remove(getCommandData(sc).name());
                    return true;
                }
            }
        }

        return false;
    }
}
