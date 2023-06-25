package com.lichenaut.vegalts.utility;

import org.bukkit.Material;

import java.util.HashSet;

public class VAFishingReference {

    public static HashSet<Material> getFish() {
        HashSet<Material> fishCategory = new HashSet<>();
        fishCategory.add(Material.COD);
        fishCategory.add(Material.SALMON);
        fishCategory.add(Material.TROPICAL_FISH);
        fishCategory.add(Material.PUFFERFISH);
        return fishCategory;
    }

    public static HashSet<Material> getJunk() {//bamboo and cocoa beans are unchanged
        HashSet<Material> junkCategory = new HashSet<>();
        junkCategory.add(Material.LILY_PAD);
        junkCategory.add(Material.BOWL);
        junkCategory.add(Material.FISHING_ROD);
        junkCategory.add(Material.LEATHER);
        junkCategory.add(Material.LEATHER_BOOTS);
        junkCategory.add(Material.ROTTEN_FLESH);
        junkCategory.add(Material.STICK);
        junkCategory.add(Material.STRING);
        junkCategory.add(Material.POTION);
        junkCategory.add(Material.BONE);
        junkCategory.add(Material.INK_SAC);
        junkCategory.add(Material.TRIPWIRE_HOOK);
        return junkCategory;
    }

    public static HashSet<Material> getTreasure() {//all fishing rods are treated as junk
        HashSet<Material> treasureCategory = new HashSet<>();
        treasureCategory.add(Material.BOW);
        treasureCategory.add(Material.ENCHANTED_BOOK);
        treasureCategory.add(Material.NAME_TAG);
        treasureCategory.add(Material.NAUTILUS_SHELL);
        treasureCategory.add(Material.SADDLE);
        return treasureCategory;
    }
}
