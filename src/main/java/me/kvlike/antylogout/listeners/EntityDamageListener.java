package me.kvlike.antylogout.listeners;

import me.kvlike.antylogout.AntyLogout;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof Player && e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK){
            Player player = (Player) e.getEntity();

            if(!AntyLogout.combat.contains(player)) {
                AntyLogout.combat.add(player);
                AntyLogout.timerMap.get(player).setTime(10);
                AntyLogout.timerMap.get(player).startTimer();
            }
            else{
                AntyLogout.timerMap.get(player).setTime(10);
            }

        }

    }

}
