package com.sharpbrakesthings.sbtutilscore.commandspy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.sharpbrakesthings.sbtutilscore.SBTUtilsCore;


public class CommandListener implements Listener {
    @SuppressWarnings("unused")
    private SBTUtilsCore plugin;

    public CommandListener(SBTUtilsCore plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player player = e.getPlayer();
            for(Player player2 : Bukkit.getOnlinePlayers()) {
                if (CommandSpyCommand.toggleCommandSpyArray.contains(player2.getUniqueId())) {
                    if (player.hasPermission("sbtutils.admin.commandspy.exempt")) {
                        return;
                    } else {
                    if (player.getUniqueId() == player2.getUniqueId()) {                        
                        } else {
                        if (player2.hasPermission("sbtutils.admin.commandspy")) {
                            player2.sendMessage(ChatColor.translateAlternateColorCodes('&', SBTUtilsCore.prefix + SBTUtilsCore.commandSpyPrefix + player.getName().toString() + "&b: Command: '&c" + e.getMessage() + "&b'"));
                        }
                    }
                }
            }
        }
    }
}
