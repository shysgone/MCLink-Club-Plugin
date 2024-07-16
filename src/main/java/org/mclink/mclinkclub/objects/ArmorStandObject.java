package org.mclink.mclinkclub.objects;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.mclink.mclinkclub.util.CC;

//TODO: PLACING SYSTEM
// ADD A SYSTEM WHERE THE ARMOR STANDS ARE EVENLY SPACED BETWEEN EACH OTHER
// THEY WILL BE IN AN ARRAY OR SOMETHING AND ADD +1-2 BLOCKS SPACE IN BETWEEN
// EACH OTHER, THIS WILL BE WEIRD TO DO BUT IT WILL BE OKAY XOXOXOXO

//
public class ArmorStandObject {
    private String name;
    private String description;
    private String id;
    private Material block;
    private Sound sound;
    private Particle particle;
    private TextDisplay txtDisplay;

    public void placeArmorStands(Player player, int numberOfStands) {
        World world = player.getWorld();
        Location playerLocation = player.getLocation();
        double halfWidth = (numberOfStands - 1) * 1.0 / 2;

        // Calculate the starting position
        Location startLocation = playerLocation.clone().add(-halfWidth, 0, 1);

        for (int i = 0; i < numberOfStands; i++) {
            // Calculate the position for this stand
            Location standLocation = startLocation.clone().add(i, 0, 0);

            // Spawn the armor stand
            ArmorStand armorStand = world.spawn(standLocation, ArmorStand.class);
            armorStand.setCustomName("Stand " + (i + 1));
            armorStand.setCustomNameVisible(true);
            armorStand.setGlowing(true);
        }
    }


    public void addArmorStand(Player player, String name, String description, Material block, Sound sound) {
        try {

            org.bukkit.entity.ArmorStand armorStand = (org.bukkit.entity.ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
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

    public ArmorStandObject(String name, String description, String id, Material block, Sound sound) {
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
