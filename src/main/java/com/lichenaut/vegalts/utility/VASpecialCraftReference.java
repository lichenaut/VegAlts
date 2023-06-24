package com.lichenaut.vegalts.utility;

import org.bukkit.Material;

import java.util.HashSet;

public class VASpecialCraftReference {

    public static HashSet<Material> getContainerConsumers() {
        HashSet<Material> containerConsumers = new HashSet<>();
        containerConsumers.add(Material.MILK_BUCKET);
        return containerConsumers;
    }

    public static HashSet<Material> getHydraters() {
        HashSet<Material> hydraters = new HashSet<>();
        hydraters.add(Material.LEATHER);
        hydraters.add(Material.RABBIT_HIDE);
        return hydraters;
    }

    public static HashSet<Material> getDehydraters() {
        HashSet<Material> dehydraters = new HashSet<>();
        dehydraters.add(Material.HONEYCOMB);
        return dehydraters;
    }

    public static HashSet<Material> getPurifiers() {
        HashSet<Material> purifiers = new HashSet<>();
        purifiers.add(Material.SPIDER_EYE);
        return purifiers;
    }
}