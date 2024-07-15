package org.mclink.mclinkclub;

import org.bukkit.plugin.java.JavaPlugin;
import org.mclink.mclinkclub.commands.ClubCommand;
import org.mclink.mclinkclub.commands.TestCommand;
import org.mclink.mclinkclub.commands.VipCommand;
import org.mclink.mclinkclub.listeners.OnClickListener;

import java.util.Objects;

public final class Club extends JavaPlugin {

    public static Club plugin;

    @Override
    public void onEnable() {
        plugin = this;

        registerCommands();
        registerListeners();

        getLogger().info("Clubs plugin is enabled");

    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("club")).setExecutor(new ClubCommand());
        Objects.requireNonNull(getCommand("vip")).setExecutor(new VipCommand());
        Objects.requireNonNull(getCommand("test")).setExecutor(new TestCommand());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new OnClickListener(), this);
    }

    @Override
    public void onDisable() {

        getLogger().info("Clubs plugin is disabled");
        // Plugin shutdown logic
    }
}
