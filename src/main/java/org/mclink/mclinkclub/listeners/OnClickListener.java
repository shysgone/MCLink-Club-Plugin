package org.mclink.mclinkclub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.util.Vector;
import org.mclink.mclinkclub.commands.ClubCommand;
import org.mclink.mclinkclub.enums.ArmorStandEnum;
import org.mclink.mclinkclub.util.CC;
import org.mclink.mclinkclub.util.PlayerUtils;
import org.w3c.dom.Text;

import java.util.Objects;

public class OnClickListener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        Entity blockClicked = event.getRightClicked();

        if (event.getRightClicked().getType().equals(EntityType.ARMOR_STAND)) {
            switch (ClubCommand.clubStand.getId()) {
                case "club":
                    PlayerUtils.sendMessage(player, "&7&oClicked club");
                    PlayerUtils.playSound(player, ClubCommand.clubStand.getSound(), 1, 6);
                    removeEntities();
                    break;
                case "admin":
                    PlayerUtils.sendMessage(player, "&7&oClicked admin");
                    PlayerUtils.playSound(player, ClubCommand.clubStand.getSound(), 1, 6);
                    removeEntities();
                    break;
                case "player":
                    PlayerUtils.sendMessage(player, "&7&oClicked player");
                    PlayerUtils.playSound(player, ClubCommand.clubStand.getSound(), 1, 6);
                    removeEntities();
                    break;
            }
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
