package com.lichenaut.vegalts.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class VATabCompleter implements TabCompleter {

    public List<String> onTabComplete(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
        List<String> options = new ArrayList<>();
        if (sender instanceof Player && sender.hasPermission("vegalts.help") && args.length == 1) {options.add("help");}
        return options;
    }
}