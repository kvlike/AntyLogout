package me.kvlike.antylogout;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Timer {

    private int time;
    private Player player;
    private int taskID;
    private final Plugin plugin = AntyLogout.getPlugin(AntyLogout.class);

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Timer(int time, Player player){
        this.time = time;
        this.player = player;
    }

    public void startTimer() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        taskID = scheduler.scheduleSyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                if(time == 0) {
                    AntyLogout.combat.remove(player);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',"&7&l>> &2&lMOZESZ SIE WYLOGOWAC &7&l<<")));
                    stopTimer();
                    return;
                }
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',"&7&l>> &4&lANTY LOGOUT &7&l<<")));
                time--;
            }
        }, 0L, 20L);
    }

    public void stopTimer() {
        Bukkit.getScheduler().cancelTask(taskID);
    }
}
