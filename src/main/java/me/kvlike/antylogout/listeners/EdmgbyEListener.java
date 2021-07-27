package me.kvlike.antylogout.listeners;

import me.kvlike.antylogout.AntyLogout;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EdmgbyEListener implements Listener {

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e){

        boolean creative = true;

        if(e.getEntity() instanceof Player){
            Player player = (Player) e.getEntity();
            if(player.getGameMode() != GameMode.SURVIVAL){
                creative = false;
            }
        }
        if(e.getDamager() instanceof Player){
            Player player = (Player) e.getDamager();
            if(player.getGameMode() != GameMode.SURVIVAL){
                creative = false;
            }
        }

        //if(e.getEntity() instanceof Player && creative){
        //    Player player = (Player) e.getEntity();

        //    if(!AntyLogout.combat.contains(player)) {
        //        AntyLogout.combat.add(player);
        //        AntyLogout.timerMap.get(player).setTime(10);
        //        AntyLogout.timerMap.get(player).startTimer();
        //    }
        //    else{
        //        AntyLogout.timerMap.get(player).setTime(10);
        //    }

        //}
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player && creative){
            Player player = (Player) e.getDamager();

            if(!AntyLogout.combat.contains(player)) {
                AntyLogout.combat.add(player);
                AntyLogout.timerMap.get(player).setTime(10);
                AntyLogout.timerMap.get(player).startTimer();
            }
            else{
                AntyLogout.timerMap.get(player).setTime(10);
            }

            player = (Player) e.getEntity();

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
