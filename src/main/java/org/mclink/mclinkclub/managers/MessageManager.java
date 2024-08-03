package org.mclink.mclinkclub.managers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.mclink.mclinkclub.util.PlayerUtils;

public class MessageManager {
    public static void sendHelpMessage(Player player) {
        PlayerUtils.clearScreen(player);
        PlayerUtils.sendMessage(player, "&d&lCLUB &7[Clickable Commands]");
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.clickableMessage("&5[Admin]", "/club admin", "RUN COMMAND", player);
        PlayerUtils.clickableMessage("&5[Player]", "/club player", "RUN COMMAND", player);
        PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 5.0f);
    }

    public static void sendAdminArgMessage(Player player) {
        PlayerUtils.clearScreen(player);
        PlayerUtils.sendMessage(player, "&5&lAdmin");
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.clickableMessage("&cExit", "/club", "RUN COMMAND", player);
        PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 5.0f);
    }

    public static void sendPlayerArgMessage(Player player) {
        PlayerUtils.clearScreen(player);
        PlayerUtils.sendMessage(player, "&5&lPlayer");
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.clickableMessage("&cExit", "/club", "RUN COMMAND", player);
        PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 5.0f);
    }



}