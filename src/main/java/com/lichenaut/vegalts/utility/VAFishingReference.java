package com.lichenaut.vegalts.utility;

import org.bukkit.Material;

import java.util.HashSet;

public class VAFishingReference {

    private final HashSet<Material> fishCategory;
    private final HashSet<Material> junkCategory;
    private final HashSet<Material> treasureCategory;

    public VAFishingReference() {
        fishCategory = new HashSet<>();
        junkCategory = new HashSet<>();
        treasureCategory = new HashSet<>();

        fishCategory.add(Material.COD);
        fishCategory.add(Material.SALMON);
        fishCategory.add(Material.TROPICAL_FISH);
        fishCategory.add(Material.PUFFERFISH);
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
        treasureCategory.add(Material.BOW);
        treasureCategory.add(Material.ENCHANTED_BOOK);
        treasureCategory.add(Material.NAME_TAG);
        treasureCategory.add(Material.NAUTILUS_SHELL);
        treasureCategory.add(Material.SADDLE);
    }

    public HashSet<Material> getFish() {return fishCategory;}

    public HashSet<Material> getJunk() {return junkCategory;}

    public HashSet<Material> getTreasure() {return treasureCategory;}
}
