package me.kvlike.antylogout.listeners;

import me.kvlike.antylogout.AntyLogout;
import me.kvlike.antylogout.Timer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        AntyLogout.timerMap.put(e.getPlayer(), new Timer(10, e.getPlayer()));
        if(AntyLogout.combat.contains(e.getPlayer())){
            AntyLogout.combat.remove(e.getPlayer());
        }

    }

}
