package org.mclink.mclinkclub.util;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerUtils {

    public static void sendMessage(Player player, String message) {
        player.sendMessage(CC.translate(message));
    }

    public static void clickableMessage(String message, String command, String hover, Player player) {
        TextComponent text = new TextComponent(CC.translate(message));
        text.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command));
        text.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(hover).color(ChatColor.GRAY).create()));
        player.spigot().sendMessage(text);
    }

    public static void clearScreen(Player player) {
        for (int i = 0; i < 100; i++) {
            PlayerUtils.sendMessage(player, "&0");
            // + ThreadLocalRandom.current().nextDouble()
        }
    }

    public static void playSound(Player player, Sound sound, float volume, float pitch) {
        player.playSound(player.getLocation(), sound, volume, pitch);
    }

    public static void teleport(Player player, Location location) {
        player.teleport(location);
    }

    public static void teleport(Player player, Player target) {
        player.teleport(target);
    }

    public static void teleport(Player player, World world, double x, double y, double z) {
        player.teleport(new Location(world, x, y, z));
    }

    public static void teleport(Player player, World world, double x, double y, double z, float yaw, float pitch) {
        player.teleport(new Location(world, x, y, z, yaw, pitch));
    }

    public static void teleport(Player player, double x, double y, double z) {
        player.teleport(new Location(player.getWorld(), x, y, z));
    }

    public static void teleport(Player player, double x, double y, double z, float yaw, float pitch) {
        player.teleport(new Location(player.getWorld(), x, y, z, yaw, pitch));
    }

    public static void teleport(Player player, Entity entity) {
        player.teleport(entity);
    }

    public static void teleport(Player player, Location location, PlayerTeleportEvent.TeleportCause cause) {
        player.teleport(location, cause);
    }

    public static void teleport(Player player, Entity entity, PlayerTeleportEvent.TeleportCause cause) {
        player.teleport(entity, cause);
    }

    public static void teleport(Player player, double x, double y, double z, PlayerTeleportEvent.TeleportCause cause) {
        player.teleport(new Location(player.getWorld(), x, y, z), cause);
    }

    public static void teleport(Player player, double x, double y, double z, float yaw, float pitch, PlayerTeleportEvent.TeleportCause cause) {
        player.teleport(new Location(player.getWorld(), x, y, z, yaw, pitch), cause);
    }

    public static void teleport(Player player, World world, double x, double y, double z, PlayerTeleportEvent.TeleportCause cause) {
        player.teleport(new Location(world, x, y, z), cause);
    }

    public static void playSound(Player player, Sound sound) {
    }
}
