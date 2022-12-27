package com.sharpbrakesthings.sbtutilscore.admingui;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sharpbrakesthings.sbtutilscore.InventorySetting;
import com.sharpbrakesthings.sbtutilscore.SBTUtilsCore;

public class AdminGuiCommand implements CommandExecutor{
    @SuppressWarnings("unused")
    private SBTUtilsCore plugin;
    
    public static Player player;
    
    public AdminGuiCommand(SBTUtilsCore plugin){
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.playerOnly));
        } else {
        Player player = (Player) sender;
        if (player.hasPermission("sbtutils.admin.gui")) {
            InventorySetting.applyAdminGUI(player);
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.noPerms));
            }
        }
        return true;
    }

}
