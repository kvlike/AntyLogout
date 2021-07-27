package me.kvlike.antylogout.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            ((Player) sender).kickPlayer(ChatColor.GREEN + "Wylogowano pomyslnie.");

        }

        return true;
    }
}
