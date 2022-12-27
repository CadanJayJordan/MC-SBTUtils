package com.sharpbrakesthings.sbtutilscore.adminchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sharpbrakesthings.sbtutilscore.SBTUtilsCore;

public class AdminChat implements CommandExecutor{
    @SuppressWarnings("unused")
    private SBTUtilsCore plugin;
    
    private String message;
        
    public static Player player;
    
    public AdminChat(SBTUtilsCore plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
            if (!sender.hasPermission("sbtutils.admin.chat")) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.noPerms));
            } else {
                if (args.length > 0) {
                    message = "";
                    for (int i = 0; i < args.length; i++) {
                      String arg = args[i] + " ";
                      message = message + arg;
                    }
                    for (Player playerAll : Bukkit.getOnlinePlayers()) {
                        if (!playerAll.hasPermission("sbtutils.admin.chat")) {} else {
                            playerAll.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.adminChatPrefix + player.getName() + "&f: " + message));
                        }
                    }
                } else { sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.adminChatPrefix + "&4Please enter a message")); }
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.playerOnly));
        }
        return true;
    }
}
