package me.grubasklucha;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;


public class WalmartTerminatorListener implements Listener {
    private final long cooldown = 200L; // 200 milliseconds (0.20 seconds) cooldown
    private long lastShotTime = 0;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getItem() != null && event.getItem().isSimilar(ItemManager.CreateWalmartTerminator())) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR ||
                    event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                    long currentTime = System.currentTimeMillis();
                if (currentTime - lastShotTime >= cooldown) {
                    Location loc = player.getEyeLocation();
                    Vector direction = loc.getDirection();
                    double angle = Math.toRadians(3);

                    // Calculate the direction of the right projectile
                    Vector rightProjectileDirection = rotateVectorInXZ(direction, angle);

                    // Calculate the direction of the left projectile
                    Vector leftProjectileDirection = rotateVectorInXZ(direction, -angle);

                    // Spawn arrows
                    Arrow middleArrow = player.getWorld().spawnArrow(loc, direction, 3F, 0);
                    Arrow rightArrow = player.getWorld().spawnArrow(loc, rightProjectileDirection, 3F, 0);
                    Arrow leftArrow = player.getWorld().spawnArrow(loc, leftProjectileDirection, 3F, 0);

                    // Set arrow shooters
                    middleArrow.setShooter(player);
                    leftArrow.setShooter(player);
                    rightArrow.setShooter(player);
                    lastShotTime = currentTime;
                    event.setCancelled(true);
                }
            }
        }
    }

    static Vector rotateVectorInXZ(Vector vector, double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);

        double x = cos * vector.getX() - sin * vector.getZ();
        double z = sin * vector.getX() + cos * vector.getZ();

        return new Vector(x, vector.getY(), z);
    }
}


