package com.lichenaut.vegalts.listeners.thirteen;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VAEggThrowListener implements Listener {

    @EventHandler
    public void onVegEggThrow(PlayerEggThrowEvent e) {//fake eggs do not hatch
        ItemStack egg = new ItemStack(Material.EGG, 1);
        ItemMeta eggMeta = egg.getItemMeta();
        eggMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        egg.setItemMeta(eggMeta);

        if (((ItemStack) e.getEgg()).isSimilar(egg)) {e.setHatching(false);}
    }
}
