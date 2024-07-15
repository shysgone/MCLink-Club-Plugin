package org.mclink.mclinkclub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mclink.mclinkclub.util.CC;
import org.mclink.mclinkclub.util.PlayerUtils;

public class VipCommand implements CommandExecutor {

    public static VipCommand vipCommand;



    // TODO:
    // Make VIP command args,
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String list, String[] args) {

        if (!(sender instanceof Player)) {
            Bukkit.getLogger().info("You can only execute commands in game");
        }

        assert sender instanceof Player;
        Player player = (Player) sender;


        if (!(sender.isOp())) {
            PlayerUtils.sendMessage(player, "&rYou do not have permission");
        }

        switch (args.length) {
            case 0:
                PlayerUtils.sendMessage(player, "&a&lVIP");
                PlayerUtils.sendMessage(player, "&7mclink.org");
                PlayerUtils.clickableMessage("&aAdmin", "/vip", "RUN COMMAND", player);
                PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 2.0f);
                break;

            case 1:
                Player target = Bukkit.getPlayer(args[0]);
                assert target != null;
                if (!(Bukkit.getOnlinePlayers().contains(target))) {
                    PlayerUtils.sendMessage(player, "&eThat player is not online");
                } else {
                    PlayerUtils.sendMessage(player, "&eTarget: " + target.getDisplayName());
                }
                break;
        }

        return false;
    }
}