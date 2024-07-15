package org.mclink.mclinkclub.club;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.mclink.mclinkclub.util.CenterText;
import org.mclink.mclinkclub.util.PlayerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandMenus {

    public List<String> headers1 = new ArrayList<String>();

    public static void buildMenu(Player player, List<String> headers1, List<String> commands, Boolean sound) {
        PlayerUtils.clearScreen(player);
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.clickableMessage("&cExit", "/club", "RUN COMMAND", player);
        if (sound) {
            PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 5.0f);
        }
    }

    public static void mainMenu(Player player) {
        PlayerUtils.clearScreen(player);
        PlayerUtils.sendMessage(player, "&d&lCLUB &7[Clickable Commands]");
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.clickableMessage("&5[Admin]", "/club admin", "RUN COMMAND", player);
        PlayerUtils.clickableMessage("&5[Player]", "/club player", "RUN COMMAND", player);
        PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 5.0f);
    }

    public static void adminArg(Player player) {
        PlayerUtils.clearScreen(player);
        PlayerUtils.sendMessage(player, "&5&lAdmin");
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.clickableMessage("&cExit", "/club", "RUN COMMAND", player);
        PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 5.0f);
    }

    public static void playerArg(Player player) {
        PlayerUtils.clearScreen(player);
        PlayerUtils.sendMessage(player, "&5&lPlayer");
        PlayerUtils.sendMessage(player, " ");
        PlayerUtils.clickableMessage("&cExit", "/club", "RUN COMMAND", player);
        PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 5.0f);
    }



}
