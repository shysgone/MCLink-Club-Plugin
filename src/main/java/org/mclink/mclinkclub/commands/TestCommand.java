package org.mclink.mclinkclub.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.mclink.mclinkclub.util.PlayerUtils;

public class TestCommand implements CommandExecutor {

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
            return true;
        }

        return false;
    }
}
