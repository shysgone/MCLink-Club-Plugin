package org.mclink.mclinkclub.enums;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.mclink.mclinkclub.util.CC;
import org.mclink.mclinkclub.util.PlayerUtils;

public class ArmorStandEnum {
    private String name;
    private String description;
    private String id;
    private Material block;
    private Sound sound;
    private Particle particle;
    private TextDisplay txtDisplay;

    public void addArmorStand(Player player, String name, String description, Material block, Sound sound) {
        try {

            ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            armorStand.setGlowing(false);
            armorStand.setVisible(false);
            armorStand.setCustomName(CC.translate(name));
            armorStand.setCustomNameVisible(false);

            BlockDisplay playerBlock = player.getWorld().spawn(player.getLocation().add(-0.5, 1, -0.5), BlockDisplay.class);
            if(block.isBlock()) playerBlock.setBlock(Bukkit.createBlockData(block));
            playerBlock.setBillboard(Display.Billboard.FIXED);

            txtDisplay = player.getWorld().spawn(player.getLocation().add(0, 2.2, 0), TextDisplay.class);
            txtDisplay.setCustomName(CC.translate(name)); //title
            txtDisplay.setText(CC.translate(description)); //description
            txtDisplay.setCustomNameVisible(true);
            txtDisplay.setBillboard(Display.Billboard.CENTER);

            //PlayerUtils.playSound(player, sound, 1, 1);

        } catch (Throwable t) {
            player.sendMessage("Error: " + t.getMessage());
        }
    }

    public void addArmorStand(Player player) {
        addArmorStand(player, this.name, this.description, this.block, this.sound);
    }

    public ArmorStandEnum(String name, String description, String id, Material block, Sound sound) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.block = block;
        this.sound = sound;
//         this.particle = particle;
    }


    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() { return id; }

    public Material getBlock() {
        return block;
    }


    public Sound getSound() {
        return sound;
    }

    public Particle getParticle() {
        return particle;
    }


    public TextDisplay getTextDisplay() {
        return txtDisplay;
    }

    public String getTextDescription(){
        return txtDisplay.getText();
    }

    public String getTextTitle() {
        return txtDisplay.getCustomName();
    }

    public Color getTextColor() {
        return txtDisplay.getBackgroundColor();
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) { this.id = id; }

    public void setBlock(Material block) {
        this.block = block;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public void setParticle(Particle particle) {
        this.particle = particle;
    }
}
