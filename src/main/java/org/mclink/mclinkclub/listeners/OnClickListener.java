package org.mclink.mclinkclub.listeners;

import jdk.internal.classfile.ClassBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.mclink.mclinkclub.commands.ClubCommand;
import org.mclink.mclinkclub.util.PlayerUtils;

import java.util.Objects;

public class OnClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();


        if (event.getRightClicked().getType().equals(EntityType.ARMOR_STAND)) {
            switch (ClubCommand.clubStand.getId()) {
                case "club":
                    PlayerUtils.playSound(player, ClubCommand.clubStand.getSound(), 1, 6);
                    removeEntities();
                    ClubCommand.clubStand.placeArmorStands(player, 5);
                    break;
                case "admin":
                    PlayerUtils.playSound(player, ClubCommand.adminStand.getSound(), 1, 6);
                    removeEntities();
                    ClubCommand.adminStand.placeArmorStands(player, 3);
                    break;
                case "player":
                    PlayerUtils.playSound(player, ClubCommand.playerStand.getSound(), 1, 6);
                    removeEntities();
                    ClubCommand.playerStand.placeArmorStands(player, 7);
                    break;
            }

            PlayerUtils.sendMessage(player, "Clicked on " + ClubCommand.clubStand.getId());
        }
    }

    public void removeEntities() {
        Objects.requireNonNull(Bukkit.getWorld("world")).getEntities().forEach(ent -> {
            if (ent instanceof BlockDisplay) ent.remove();
            if (ent instanceof ArmorStand) ent.remove();
            if (ent instanceof TextDisplay) ent.remove();
        });
    }

}
