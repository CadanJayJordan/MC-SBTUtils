package com.sharpbrakesthings.sbtutilscore.admingui;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.sharpbrakesthings.sbtutilscore.SBTUtilsCore;



public class AdminGUIListener implements Listener{
    @SuppressWarnings("unused")
    private SBTUtilsCore plugin;
    
    public AdminGUIListener(SBTUtilsCore plugin){
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;
        if (e.getCurrentItem() == null) return;
        Player player = (Player) e.getWhoClicked();
        
        if (ChatColor.translateAlternateColorCodes('&', e.getView().getTitle()).equals(ChatColor.DARK_BLUE + "Admin: " + ChatColor.DARK_RED + player.getName())) {
            if(e.getCurrentItem() != null) {
                e.setCancelled(true);
                
                switch(e.getCurrentItem().getType()) {
                case GLASS:
                    player.performCommand("SuperVanish:sv");
                    break;
                case COMMAND_BLOCK:
                    player.performCommand("sbtutils:cs");
                    break;
                default:
                    return;
                }
                player.closeInventory();
            } else {
                return;
            }
        } else {
            return;
        }
    }
}
