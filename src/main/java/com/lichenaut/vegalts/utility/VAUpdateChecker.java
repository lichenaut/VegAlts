package com.lichenaut.vegalts.utility;

import com.lichenaut.vegalts.VegAlts;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class VAUpdateChecker {

    private final JavaPlugin plugin;
    private final VegAlts vaPlugin;

    public VAUpdateChecker(JavaPlugin plugin, VegAlts dlPlugin) {this.plugin = plugin;this.vaPlugin = dlPlugin;}

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + 110827).openStream(); Scanner scanner = new
                    Scanner(inputStream)) {if (scanner.hasNext()) {consumer.accept(scanner.next());}
            } catch (IOException e) {
                vaPlugin.getLog().warning("Unable to check for updates!");
                e.printStackTrace();
            }
        });
    }
}