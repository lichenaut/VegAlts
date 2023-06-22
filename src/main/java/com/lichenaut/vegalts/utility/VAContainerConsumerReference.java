package com.lichenaut.vegalts.utility;

import org.bukkit.Material;

import java.util.HashSet;

public class VAContainerConsumerReference {

    public static HashSet<Material> getContainerConsumers() {
        HashSet<Material> containerConsumers = new HashSet<>();
        containerConsumers.add(Material.MILK_BUCKET);
        containerConsumers.add(Material.EGG);
        containerConsumers.add(Material.HONEY_BOTTLE);
        return containerConsumers;
    }


}
