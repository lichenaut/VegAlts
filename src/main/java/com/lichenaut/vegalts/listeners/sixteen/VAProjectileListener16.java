package com.lichenaut.vegalts.listeners.sixteen;

import org.bukkit.entity.ThrowableProjectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

public class VAProjectileListener16 implements Listener {

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent e) {//fake eggs do not hatch, versions 1.16.1+
        ThrowableProjectile egg = e.getEgg();
        if (egg.hasMetadata("veg")) e.setHatching(false);
    }
}