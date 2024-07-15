package org.mclink.mclinkclub.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.mclink.mclinkclub.club.CommandMenus;
import org.mclink.mclinkclub.enums.ArmorStandEnum;
import org.mclink.mclinkclub.util.CC;
import org.mclink.mclinkclub.util.PlayerUtils;

import java.util.Arrays;

public class ClubCommand implements CommandExecutor {

    public static ClubCommand clubCommand;

    public static ArmorStandEnum clubStand = new ArmorStandEnum("&d&lCLUB", "&7[MAIN CLUB COMMANDS]",
            "club", Material.GRASS_BLOCK, Sound.BLOCK_NOTE_BLOCK_PLING);

    public static ArmorStandEnum adminStand = new ArmorStandEnum("&c&lADMIN", "&7[MAIN ADMIN COMMANDS]",
            "admin", Material.COMMAND_BLOCK, Sound.BLOCK_NOTE_BLOCK_PLING);

    public static ArmorStandEnum playerStand = new ArmorStandEnum("&a&lPLAYER", "&7[MAIN PLAYER COMMANDS]",
            "player", Material.COAL_BLOCK, Sound.BLOCK_NOTE_BLOCK_PLING);



    // TODO:
    // Make the actual CLUB command arguments do shit and make sense
    // . . . . . . .
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String list, String[] args) {
        if (!(sender instanceof Player)) { Bukkit.getLogger().info("You can only execute commands in game"); }
        assert sender instanceof Player;
        Player player = (Player) sender;

        if (!(sender.isOp())) {
            PlayerUtils.sendMessage(player, "&4You do not have permission");
        } else {
            switch (args.length) {
                case 0:
                    CommandMenus.mainMenu(player);
                    break;
                case 1:
                    if (args[0].equalsIgnoreCase("admin")) {
                        CommandMenus.adminArg(player);
                    }
                    
                    if (args[0].equalsIgnoreCase("player")) {
                        CommandMenus.playerArg(player);
                    }

                    if (args[0].equalsIgnoreCase("test")) {

                    }
                    break;
                case 2:
                    if(args[0].equalsIgnoreCase("test") && args[1].equalsIgnoreCase("club")) {
                        try {
                            clubStand.addArmorStand(player);
                        } catch (Throwable e) {
                            player.sendMessage("Error: " + e.getMessage());
                        }
                    }

                    break;
            }
        }

        return false;
    }
}