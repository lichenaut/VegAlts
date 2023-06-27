package com.lichenaut.vegalts.listeners.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;

public class VAEnderPearlListener implements Listener {

    private final VegAlts plugin;

    public VAEnderPearlListener(VegAlts plugin) {this.plugin = plugin;}

    @EventHandler
    public void onPlayerPearlThrow(ProjectileLaunchEvent e) {//has item meta -> is fake pearl -> set persistent data
        Projectile projectile = e.getEntity();
        if (projectile.getType() == EntityType.ENDER_PEARL && projectile.getShooter() instanceof Player) {
            Player p = (Player) projectile.getShooter();
            ItemStack playerPearl = new ItemStack(Material.ENDER_PEARL);
            if (p.getInventory().getItemInMainHand().getType() == Material.ENDER_PEARL) playerPearl = p.getInventory().getItemInMainHand();
            else if (p.getInventory().getItemInOffHand().getType() == Material.ENDER_PEARL) playerPearl = p.getInventory().getItemInOffHand();

            ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
            ItemMeta pearlMeta = pearl.getItemMeta();
            pearlMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            pearl.setItemMeta(pearlMeta);

            if (playerPearl.isSimilar(pearl)) e.getEntity().setMetadata("veg_ender_pearl_meta", new FixedMetadataValue(plugin, true));
        }
    }

    @EventHandler
    public void onPearlHit(ProjectileHitEvent e) {//fake pearls do not spawn endermites
        Projectile projectile = e.getEntity();
        if (projectile.hasMetadata("veg_ender_pearl_meta") && projectile.getType() == EntityType.ENDER_PEARL && projectile.getShooter() instanceof Player) Objects.requireNonNull(e.getHitBlock()).getLocation().getNearbyLivingEntities(2).forEach(entity -> {if (entity.getType() == EntityType.ENDERMITE) entity.remove();});
    }
}
