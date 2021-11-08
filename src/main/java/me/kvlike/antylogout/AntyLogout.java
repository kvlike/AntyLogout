package me.kvlike.antylogout;

import me.kvlike.antylogout.commands.LeaveCommand;
import me.kvlike.antylogout.listeners.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class AntyLogout extends JavaPlugin {

    public static ArrayList<Player> combat;
    public static Map<Player, Timer> timerMap;

    @Override
    public void onEnable() {

        combat = new ArrayList<>();
        timerMap = new HashMap<>();

        //getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new EdmgbyEListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);
        getServer().getPluginManager().registerEvents(new CommandListener(), this);

        getCommand("leave").setExecutor(new LeaveCommand());

    }

}
