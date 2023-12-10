package me.grubasklucha;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.block.Block;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;


public class WandListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Check if the player right-clicked with a Magic Wand
        Player player = event.getPlayer();
        if (event.getItem() != null && event.getItem().isSimilar(ItemManager.CreateMagicWand())) {
            // Handle the event here
            // This is where you can put your custom logic when the Magic Wand is used
            Block clickedBlock = event.getClickedBlock();
            if (clickedBlock != null && (clickedBlock.getType() == Material.GRASS_BLOCK
                    || clickedBlock.getType() == Material.DIRT
                    || clickedBlock.getType() == Material.COARSE_DIRT
                    || clickedBlock.getType() == Material.ROOTED_DIRT
                    || clickedBlock.getType() == Material.DIRT_PATH)) {
                // Cancel the event to prevent tilling
                event.setCancelled(true);
            }
            // Check if the clicked block is not null and is not air
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (clickedBlock != null && clickedBlock.getType() != Material.AIR) {
                    // Get the coordinates of the clicked block
                    int x = clickedBlock.getX();
                    int y = clickedBlock.getY();
                    int z = clickedBlock.getZ();
                    Material mat = clickedBlock.getType();
                    // Handle the event here with the block coordinates
                    event.getPlayer().sendMessage("You used the Magic Wand on block at coordinates: "
                            + ChatColor.RED + " X=" + x
                            + ChatColor.GREEN + ", Y=" + y
                            + ChatColor.BLUE + ", Z=" + z
                            + ChatColor.WHITE + ", and the material type is: " + ChatColor.AQUA + mat);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 0.2F);
                }
            }
            if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
                assert clickedBlock != null;
                int x = clickedBlock.getX();
                int y = clickedBlock.getY();
                int z = clickedBlock.getZ();
                Material previous_type = clickedBlock.getType();
                if (previous_type != Material.GOLD_BLOCK) {
                    clickedBlock.setType(Material.GOLD_BLOCK);
                    event.getPlayer().sendMessage("You have turned a block at location: "
                            + ChatColor.RED + " X=" + x
                            + ChatColor.GREEN + ", Y=" + y
                            + ChatColor.BLUE + ", Z=" + z
                            + ChatColor.WHITE + " from a "
                            + ChatColor.YELLOW + previous_type
                            + ChatColor.WHITE + " to : "
                            + ChatColor.GOLD + "A GOLD BLOCK!");
                    event.getPlayer().updateInventory();
                } else {
                    event.getPlayer().sendMessage(" This Block is already a " + ChatColor.GOLD + "gold block!");
                }
                player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.5F, 0.8F);

            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();

        // Check if the player is in creative mode and holding the Magic Wand
        if (player.getGameMode() == GameMode.CREATIVE && isHoldingMagicWand(player)) {
            // Cancel the block break event
            event.setCancelled(true);
        }

    }

    // Helper method to check if the player is holding the Magic Wand
    private boolean isHoldingMagicWand(Player player) {
        ItemStack heldItem = player.getInventory().getItemInMainHand();
        return heldItem != null && heldItem.isSimilar(ItemManager.CreateMagicWand());
    }
}
