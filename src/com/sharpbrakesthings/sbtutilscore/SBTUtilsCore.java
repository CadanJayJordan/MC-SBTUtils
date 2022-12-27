package com.sharpbrakesthings.sbtutilscore;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sharpbrakesthings.sbtutilscore.adminchat.AdminChat;
import com.sharpbrakesthings.sbtutilscore.admingui.AdminGUIListener;
import com.sharpbrakesthings.sbtutilscore.admingui.AdminGuiCommand;
import com.sharpbrakesthings.sbtutilscore.commandspy.CommandListener;
import com.sharpbrakesthings.sbtutilscore.commandspy.CommandSpyCommand;
import com.sharpbrakesthings.sbtutilscore.sbtutilscmd.SBTUtilsCMD;


public class SBTUtilsCore extends JavaPlugin{
        
    public static String prefix;
    public static String adminChatPrefix;
    public static String commandSpyPrefix;
    public static String noPerms;
    public static String playerOnly;
    public static String cmdNotRecongnised;
    
    public static String version;
    public static String pluginName;
    
    @Override
    public void onEnable() {
        loadConfig();
        
        version = this.getDescription().getVersion();
        pluginName = this.getDescription().getName();
        
        /*Logging*/
        getServer().getLogger().info("[" + pluginName + "] Version " + version + " loaded successfully");     
  
        /*CommandSpy*/
        Bukkit.getPluginManager().registerEvents(new CommandListener(this), this);
        getCommand("cs").setExecutor(new CommandSpyCommand(this));
        
        /*Admin GUI*/
        Bukkit.getPluginManager().registerEvents(new AdminGUIListener(this), this);
        getCommand("admin").setExecutor(new AdminGuiCommand(this));
        
        /*Admin Chat*/
        getCommand("adminchat").setExecutor(new AdminChat(this));
        
        /*SBTUtils*/
        getCommand("sbtutils").setExecutor(new SBTUtilsCMD(this));
    }
    
    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks((Plugin)this);
        HandlerList.unregisterAll((Plugin)this);
        getServer().getLogger().info("[" + this.getDescription().getName() + "] Version " + this.getDescription().getVersion() + " unloaded successfully");
    }
    
    public void loadConfig() {
        saveDefaultConfig();
        
        prefix = getConfig().getString("prefix");
        adminChatPrefix = getConfig().getString("adminChatPrefix");
        commandSpyPrefix = getConfig().getString("commandSpyPrefix");
        noPerms = getConfig().getString("noPermissions");
        playerOnly = getConfig().getString("playerOnly");
        cmdNotRecongnised = getConfig().getString("cmdNotRecongnised");

    }

    public void reload() {
      onDisable();
      reloadConfig();
      onEnable();
      
    }

}
