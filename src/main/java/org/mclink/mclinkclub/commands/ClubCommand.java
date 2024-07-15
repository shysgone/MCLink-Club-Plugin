package org.mclink.mclinkclub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.mclink.mclinkclub.club.CommandMenus;
import org.mclink.mclinkclub.util.CC;
import org.mclink.mclinkclub.util.PlayerUtils;

import java.util.Arrays;

public class ClubCommand implements CommandExecutor {

    public static ClubCommand clubCommand;



    // TODO:
    // Make the actual CLUB command arguments do shit and make sense
    // . . . . . . .
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String list, String[] args) {

        if (!(sender instanceof Player)) {
            Bukkit.getLogger().info("You can only execute commands in game");
        }

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

                        /*ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(1.5, 0, 3), EntityType.ARMOR_STAND);
                        armorStand.setGlowing(true);
                        armorStand.setVisible(false);
                        armorStand.setCustomNameVisible(true);
                        armorStand.setCustomName(CC.translate("&d&lClub"));*/
                        //CommandMenus.buildMenu(player, Arrays.asList("dad", "adad", "adad"), Arrays.asList("dad", "adad", "adad"), true);
                    }
                    break;
                case 2:
                    if(args[0].equalsIgnoreCase("test") && args[1].equalsIgnoreCase("club")) {
                        try {
                            BlockDisplay clubBlock = player.getWorld().spawn(player.getLocation().add(1.5, 1, -0.5), BlockDisplay.class);
                            clubBlock.setBlock(Bukkit.createBlockData(Material.GRASS_BLOCK));
                            clubBlock.setBillboard(Display.Billboard.FIXED);

                            BlockDisplay adminBlock = player.getWorld().spawn(player.getLocation().add(-0.5, 1, -0.5), BlockDisplay.class);
                            adminBlock.setBlock(Bukkit.createBlockData(Material.COMMAND_BLOCK));
                            adminBlock.setBillboard(Display.Billboard.FIXED);

                            BlockDisplay playerBlock = player.getWorld().spawn(player.getLocation().add(-2.5, 1, -0.5), BlockDisplay.class);
                            playerBlock.setBlock(Bukkit.createBlockData(Material.AMETHYST_BLOCK));
                            playerBlock.setBillboard(Display.Billboard.FIXED);

                            ArmorStand clubStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(2, 0, 0), EntityType.ARMOR_STAND);
                            clubStand.setGlowing(false);
                            clubStand.setVisible(false);
                            clubStand.setCustomNameVisible(true);
                            clubStand.setCustomName(CC.translate("&d&lCLUB"));

                            ArmorStand adminStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, 0, 0), EntityType.ARMOR_STAND);
                            adminStand.setGlowing(false);
                            adminStand.setVisible(false);
                            adminStand.setCustomNameVisible(true);
                            adminStand.setCustomName(CC.translate("&c&lADMIN"));

                            ArmorStand playerStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(-2, 0, 0), EntityType.ARMOR_STAND);
                            playerStand.setGlowing(false);
                            playerStand.setVisible(false);
                            playerStand.setCustomNameVisible(true);
                            playerStand.setCustomName(CC.translate("&e&lPLAYER"));

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