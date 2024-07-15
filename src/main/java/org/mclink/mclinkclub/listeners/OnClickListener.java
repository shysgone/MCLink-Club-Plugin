package org.mclink.mclinkclub.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.util.Vector;
import org.mclink.mclinkclub.util.CC;
import org.mclink.mclinkclub.util.PlayerUtils;

import java.util.Objects;

public class OnClickListener implements Listener {


    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();

        if(event.getRightClicked().getType().equals(EntityType.ARMOR_STAND) && Objects.equals(event.getRightClicked().getCustomName(), CC.translate("&d&lCLUB"))) {
            PlayerUtils.sendMessage(player, "&7&oClicked club");
            PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 6);
            event.getRightClicked().remove();
            Objects.requireNonNull(Bukkit.getWorld("world")).getEntities().forEach(ent -> {
                if (ent instanceof BlockDisplay) ent.remove();
                if (ent instanceof ArmorStand) ent.remove();
            });
        }

        if(event.getRightClicked().getType().equals(EntityType.ARMOR_STAND) && Objects.equals(event.getRightClicked().getCustomName(), CC.translate("&c&lADMIN"))) {
            PlayerUtils.sendMessage(player, "&7&oClicked admin");
            PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 6);
            event.getRightClicked().remove();
            Objects.requireNonNull(Bukkit.getWorld("world")).getEntities().forEach(ent -> {
                if (ent instanceof BlockDisplay) ent.remove();
                if (ent instanceof ArmorStand) ent.remove();
            });
        }

        if(event.getRightClicked().getType().equals(EntityType.ARMOR_STAND) && Objects.equals(event.getRightClicked().getCustomName(), CC.translate("&e&lPLAYER"))) {
            PlayerUtils.sendMessage(player, "&7&oClicked player");
            PlayerUtils.playSound(player, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 6);
            event.getRightClicked().remove();
            Objects.requireNonNull(Bukkit.getWorld("world")).getEntities().forEach(ent -> {
                if (ent instanceof BlockDisplay) ent.remove();
                if (ent instanceof ArmorStand) ent.remove();
            });
        }
    }

}
