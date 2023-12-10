package me.grubasklucha;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.Objects;
import static org.bukkit.Bukkit.getLogger;


public class MathAxeListener implements Listener {

    public static int[] blockA = null;
    public static int[] blockB = null;

    private static void setBlockA(Location BlockACoords, Player player){
        if(BlockACoords != null) {
            int x = BlockACoords.getBlockX();
            int y = BlockACoords.getBlockY();
            int z = BlockACoords.getBlockZ();
            blockA = new int[]{x, y, z};
            player.sendMessage("Block A set!");
        }

    }
    private static void setBlockB(Location BlockBCoords, Player player){
        if(BlockBCoords != null) {
            int x = BlockBCoords.getBlockX();
            int y = BlockBCoords.getBlockY();
            int z = BlockBCoords.getBlockZ();
            blockB = new int[]{x, y, z};
            player.sendMessage("Block B set!");
        }
    }
    private static void FillSpace(int[] blockA, int[]blockB, World world){
        getLogger().info("axe is filling space....");
        if(blockA.length == 3 && blockB.length == 3){
            getLogger().info("fillspace condition met!");
            for(int x = Math.min(blockA[0],blockB[0]);x<=Math.max(blockA[0],blockB[0]); x++){
                for(int y = Math.min(blockA[1],blockB[1]);y<=Math.max(blockA[1],blockB[1]); y++){
                    for(int z = Math.min(blockA[2],blockB[2]);z<=Math.max(blockA[2],blockB[2]); z++){
                        world.getBlockAt(x,y,z).setType(Material.GOLD_BLOCK);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Block clickedblock = event.getClickedBlock();
        Player player = event.getPlayer();
        World world = player.getWorld();
        if(event.getItem()!= null && event.getItem().isSimilar(ItemManager.CreateMathAxe())) {
            if (event.getAction() == Action.LEFT_CLICK_BLOCK &&
                    clickedblock != null) {
                setBlockB(event.getClickedBlock().getLocation(), player);
                player.sendMessage(Arrays.toString(blockB));
                event.setCancelled(true);
            }
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK &&
                    clickedblock != null) {
                setBlockA(event.getClickedBlock().getLocation(), player);
                player.sendMessage(Arrays.toString(blockA));
                event.setCancelled(true);
            }
            if (blockA != null && blockB != null) {
                player.sendMessage("Condition met!");
                FillSpace(blockA, blockB, world);
                blockA = null;
                blockB = null;
            }
        }
    }
}


