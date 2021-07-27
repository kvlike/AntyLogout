package me.kvlike.antylogout.listeners;

import me.kvlike.antylogout.AntyLogout;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        if(AntyLogout.combat.contains(e.getEntity())){
            AntyLogout.combat.remove(e.getEntity());
            AntyLogout.timerMap.get(e.getEntity()).stopTimer();
        }

    }

}
