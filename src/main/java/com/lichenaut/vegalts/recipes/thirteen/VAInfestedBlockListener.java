package com.lichenaut.vegalts.recipes.thirteen;

import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class VAInfestedBlockListener implements Listener {

    @EventHandler
    public void onSilverfishSpawn(CreatureSpawnEvent e) {
        if (e.getEntityType() == EntityType.SILVERFISH) {
            Block b = e.getLocation().getBlock();
            if (b.getType().toString().endsWith("_INFESTED")) e.setCancelled(true);
        }
    }
}
