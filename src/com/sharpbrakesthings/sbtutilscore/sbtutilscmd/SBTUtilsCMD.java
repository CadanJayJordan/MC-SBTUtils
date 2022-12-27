package com.sharpbrakesthings.sbtutilscore.sbtutilscmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.sharpbrakesthings.sbtutilscore.SBTUtilsCore;

public class SBTUtilsCMD implements CommandExecutor{
    private SBTUtilsCore plugin;
    
    public SBTUtilsCMD(SBTUtilsCore plugin) {
        this.plugin = plugin;
    }
    

    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + "&bPlugin: &c" + SBTUtilsCore.pluginName + "&b Version: &c" + SBTUtilsCore.version));
        } else if(args.length > 0) {
            if(args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("sbtutils.reload")) {
                    long before = System.currentTimeMillis();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + "&aReloading Config"));
                    this.plugin.reload();
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + "&aConfig Reloaded in:&c " + (System.currentTimeMillis() - before) + "&ams"));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.noPerms));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + SBTUtilsCore.cmdNotRecongnised));
            }
        }
        return true;
    }
}
