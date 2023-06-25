package com.lichenaut.vegalts.recipes.thirteen;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VAVegEggThrowListener implements Listener {

    @EventHandler
    public void onVegEggThrow(PlayerEggThrowEvent e) {//fake eggs do not hatch
        ItemStack egg = new ItemStack(Material.EGG, 1);
        ItemMeta eggMeta = egg.getItemMeta();
        eggMeta.setCustomModelData(1);
        eggMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        egg.setItemMeta(eggMeta);

        if (e.getEgg().getItem().equals(egg)) {e.setHatching(false);}
    }
}
