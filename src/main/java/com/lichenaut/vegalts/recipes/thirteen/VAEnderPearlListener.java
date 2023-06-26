package com.lichenaut.vegalts.recipes.thirteen;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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
import org.bukkit.persistence.PersistentDataType;

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
            pearlMeta.setCustomModelData(1);
            pearlMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            pearl.setItemMeta(pearlMeta);

            if (playerPearl.isSimilar(pearl)) {
                NamespacedKey key = new NamespacedKey(plugin, "veg_ender_pearl_meta");
                projectile.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
            }
        }
    }

    @EventHandler
    public void onPearlHit(ProjectileHitEvent e) {//fake pearls do not spawn endermites
        Projectile projectile = e.getEntity();
        NamespacedKey key = new NamespacedKey(plugin, "veg_ender_pearl_meta");

        if (projectile.getPersistentDataContainer().has(key, PersistentDataType.BYTE) && projectile.getType() == EntityType.ENDER_PEARL && projectile.getShooter() instanceof Player) {
            e.setCancelled(true);
            Player p = (Player) projectile.getShooter();
            Location target = projectile.getLocation();
            float yaw = p.getLocation().getYaw();
            float pitch = p.getLocation().getPitch();
            target.setPitch(pitch);
            target.setYaw(yaw);
            p.teleport(target);
        }
    }
}
