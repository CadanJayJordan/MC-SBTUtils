package com.sharpbrakesthings.sbtutilscore.commandspy;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sharpbrakesthings.sbtutilscore.SBTUtilsCore;

public class CommandSpyCommand implements CommandExecutor{
    @SuppressWarnings("unused")
    private SBTUtilsCore plugin;
    
        
    public static ArrayList<UUID> toggleCommandSpyArray = new ArrayList<UUID>();
    public static Player player;
    
    public CommandSpyCommand(SBTUtilsCore plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
            if (!sender.hasPermission("sbtutils.commandspy")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.noPerms));
            } else {
                if (!(toggleCommandSpyArray.contains(player.getUniqueId()))){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + "&bCommand Spy &aEnabled"));
                    toggleCommandSpyArray.add(player.getUniqueId());
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + "&bCommand Spy &4Disabled"));
                    toggleCommandSpyArray.remove(player.getUniqueId());
                }
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.playerOnly));
        }
        return true;
    }
}
