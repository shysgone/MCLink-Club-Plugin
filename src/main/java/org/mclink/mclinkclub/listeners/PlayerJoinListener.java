package org.mclink.mclinkclub.listeners;

import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.mclink.mclinkclub.Club;
import org.mclink.mclinkclub.util.GenUtils;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class PlayerJoinListener implements Listener {

    private Club plugin;


    public PlayerJoinListener(Club club) {
        this.plugin = club;
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void bannedEvent(AsyncPlayerPreLoginEvent event) {
        BanList<?> banList = plugin.getServer().getBanList(BanList.Type.NAME);
        BanEntry<?> banEntry = banList.getBanEntry(event.getName()); // FIXME: DEPRECATED SO NEEDS TO BE FIXED

        if (banEntry != null) {
            Date now = new Date();
            Map<TimeUnit, Long> timeDiff = GenUtils.computeDiff(now, Objects.requireNonNull(banEntry.getExpiration()));

            String duration = timeDiff.get(TimeUnit.DAYS) + " days, " + timeDiff.get(TimeUnit.HOURS) + " hours";
            String reason = banEntry.getReason();

            String banMessage = GenUtils.banMessage(duration, reason);

            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, banMessage);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void kickedEvent(PlayerKickEvent event) {
        // TODO: Implement this
        // TODO: Check if they are banned and if so send them the ban message
    }

}
