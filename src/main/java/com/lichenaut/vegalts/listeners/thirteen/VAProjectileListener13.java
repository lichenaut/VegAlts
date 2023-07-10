package com.lichenaut.vegalts.listeners.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.ItemTagType;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.projectiles.BlockProjectileSource;

public class VAProjectileListener13 implements Listener {

    private final VegAlts plugin;

    public VAProjectileListener13(VegAlts plugin) {this.plugin = plugin;}

    @EventHandler
    public void onProjectileThrow(ProjectileLaunchEvent e) {//key match -> is fake -> set entity meta
        NamespacedKey key = new NamespacedKey(plugin, "veg");
        Projectile projectile = e.getEntity();
        if (projectile.getType() == EntityType.EGG || projectile.getType() == EntityType.ENDER_PEARL) {
            if (projectile.getShooter() instanceof Player) {
                PlayerInventory p = ((Player) projectile.getShooter()).getInventory();
                ItemMeta mainHand = p.getItemInMainHand().getItemMeta();
                ItemMeta offHand = p.getItemInOffHand().getItemMeta();
                if (mainHand != null) if (mainHand.getCustomTagContainer().hasCustomTag(key, ItemTagType.STRING)) projectile.setMetadata("veg", new FixedMetadataValue(plugin, true));
                else if (offHand != null) if (offHand.getCustomTagContainer().hasCustomTag(key, ItemTagType.STRING)) projectile.setMetadata("veg", new FixedMetadataValue(plugin, true));
            } else if (projectile.getShooter() instanceof BlockProjectileSource) ((BlockProjectileSource) projectile.getShooter()).getBlock().getDrops().forEach(item -> {if (item.getItemMeta().getCustomTagContainer().hasCustomTag(key, ItemTagType.STRING)) projectile.setMetadata("veg", new FixedMetadataValue(plugin, true));});
        }
    }

    @EventHandler
    public void onVegHit(ProjectileHitEvent e) {//fake pearls do not spawn endermites
        if (e.getEntity().hasMetadata("veg") && e.getEntity().getShooter() instanceof Player && e.getEntityType() == EntityType.ENDER_PEARL) {
            e.getEntity().remove();

            Projectile projectile = e.getEntity();
            if (e.getEntityType() == EntityType.ENDER_PEARL && projectile.getShooter() instanceof Player) {
                Player p = (Player) projectile.getShooter();
                Location target = projectile.getLocation();
                target.setPitch(p.getLocation().getPitch());
                target.setYaw(p.getLocation().getYaw());
                p.teleport(target);
            }
        }
    }
}