package com.sharpbrakesthings.sbtutilscore;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventorySetting {
    
            
    public static void applyAdminGUI(Player player) {
            
            //Beginning//
            Inventory adminGUI = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "Admin: " + ChatColor.DARK_RED + player.getName());
            //lore//        
            List<String> vanishLore = new ArrayList<>();
            vanishLore.add(ChatColor.RED + "Click to change your visibility to normal players");
            vanishLore.add(ChatColor.RED + "Command: /sv");
            
            List<String> commandSpyLore = new ArrayList<>();
            commandSpyLore.add(ChatColor.RED + "CLick to see all the commands players are executing");
            commandSpyLore.add(ChatColor.RED + "Command: /cspy");
            
            //Item stacks//
            ItemStack vanish = new ItemStack(Material.GLASS);
            ItemMeta vanishMeta = vanish.getItemMeta();
            vanishMeta.setDisplayName(ChatColor.AQUA + "Vanish");
            vanishMeta.setLore(vanishLore);
            vanish.setItemMeta(vanishMeta);
            
            ItemStack commandSpy = new ItemStack(Material.COMMAND_BLOCK);
            ItemMeta commandSpyMeta = commandSpy.getItemMeta();
            commandSpyMeta.setDisplayName(ChatColor.AQUA + "Command Spy");
            commandSpyMeta.setLore(commandSpyLore);
            commandSpy.setItemMeta(commandSpyMeta);
            
            //Settings//
            adminGUI.setItem(2, vanish);
            adminGUI.setItem(6, commandSpy);
            
            player.openInventory(adminGUI);
        }

}
