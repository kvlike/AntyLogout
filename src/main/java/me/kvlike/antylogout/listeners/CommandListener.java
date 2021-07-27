package me.kvlike.antylogout.listeners;

import me.kvlike.antylogout.AntyLogout;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){

        if(AntyLogout.combat.contains(e.getPlayer())) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "Nie mozesz uzywac komend podczas walki!");
        }

    }

}
