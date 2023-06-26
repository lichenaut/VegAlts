package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class VAInfestedBlockListener implements Listener {

    private final VegAlts plugin;

    public VAInfestedBlockListener(VegAlts plugin) {this.plugin = plugin;}

    @EventHandler
    public void onSilverfishSpawn(CreatureSpawnEvent e) {
        if (e.getEntityType() == EntityType.SILVERFISH) {
            LivingEntity silverfishTarget = ((Mob) e.getEntity()).getTarget();
            if (silverfishTarget instanceof Player) {
                Block b = e.getLocation().getBlock();
                Player p = (Player) silverfishTarget;
                if (b.getType().toString().endsWith("_INFESTED") && (p.hasPermission("vegalts.infested") || plugin.getPluginConfig().getBoolean("global-infested-spawning-off")) && !p.hasPermission("vegalts.infested.disabled")) e.setCancelled(true);
            }
        }
    }
}