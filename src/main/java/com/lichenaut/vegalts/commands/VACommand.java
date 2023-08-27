package com.lichenaut.vegalts.commands;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

@SuppressWarnings("ALL")//ChatColor is deprecated?
public class VACommand implements CommandExecutor {

    private final VegAlts plugin;

    public VACommand(VegAlts plugin) {this.plugin = plugin;}

    public void messageSender(CommandSender sender, String message) {
        if (sender instanceof Player) {sender.sendMessage(message);
        } else {plugin.getLog().info(ChatColor.stripColor(message));}
    }

    @Override
    public boolean onCommand(@Nonnull CommandSender sender, @Nonnull Command command, @Nonnull String label, @Nonnull String[] args) {
        String helpMessage = ChatColor.GRAY + "Crafting recipes and vegan mechanics can be found here: " + ChatColor.GREEN +
                "https://github.com/lichenaut/VegAlts/blob/master/README.md";
        String invalidMessage = ChatColor.RED + "Invalid usage of '" + ChatColor.WHITE + "/va" + ChatColor.RED + "'. Use '" + ChatColor.WHITE + "/va help" + ChatColor.RED + "'.";
        //StringBuilder arguments = new StringBuilder("va");
        //for (String arg : args) {arguments.append(" ").append(arg);}
        //String fakeUnknown = ChatColor.RED + "Unknown or incomplete command, see below for error\n" + ChatColor.RED + ChatColor.UNDERLINE + arguments + ChatColor.RESET + ChatColor.RED + ChatColor.ITALIC + "<--[HERE]";

        if (args.length == 0 || args[0].equals("help")) {
            messageSender(sender, helpMessage);
            return true;
        } else messageSender(sender, invalidMessage);
        return true;
    }
}