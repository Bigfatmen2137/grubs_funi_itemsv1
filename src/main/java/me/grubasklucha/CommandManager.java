package me.grubasklucha;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getLogger;

public class CommandManager implements CommandExecutor , TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("test")) {
            // Check if the sender is a player
            if (sender instanceof Player) {
                // Cast the sender to a Player
                Player player = (Player) sender;

                // Send a message to the player
                String colorname = player.getName();
                colorname = "§2" + colorname;
                player.sendMessage("Witaj, " + colorname + " !");
            } else {
                // If the sender is not a player (e.g., console), send a message to the console
                getLogger().info("Witaj konsola!");
            }

            return true;
        }
        if (cmd.getName().equalsIgnoreCase("givefunnyitem")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                // Check if the command has at least one argument (the item name)
                if (args.length >= 1) {
                    String itemName = args[0].toLowerCase(); // Convert to lowercase for case-insensitive comparison
                    if (itemName.equals("magic_wand")) {
                        ItemStack magic_wand = ItemManager.CreateMagicWand();
                        player.getInventory().addItem(magic_wand);
                        player.sendMessage("You received a magic wand!");
                        return true;

                    }
                    if (itemName.equals("math_axe")){
                        ItemStack math_axe = ItemManager.CreateMathAxe();
                        player.getInventory().addItem(math_axe);
                        player.sendMessage("You received a math axe!");
                        return true;
                    }
                    if (itemName.equals("walmart_terminator")) {
                        ItemStack walmart_terminator = ItemManager.CreateWalmartTerminator();
                        player.getInventory().addItem(walmart_terminator);
                        player.sendMessage("You received the Walmart Terminator!");
                        return true;
                    } else {
                        // Handle unknown item names
                        player.sendMessage("Unknown item: " + args[0]);
                    }
                } else {
                    player.sendMessage("Usage: /givefunnyitem <item_name>");
                }
                return true;
            } else {
                getLogger().info("Nie invokuj tego z konsoli glabie");
            }
            return true;

        }
        return false;

    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        List<String> completions = new ArrayList<String>();

        if (cmd.getName().equalsIgnoreCase("givefunnyitem")) {
            if (args.length == 1) {
                String partialItemName = args[0].toLowerCase();

                // add item names that match the partial input
                if ("magic_wand".startsWith(partialItemName)) {
                    completions.add("magic_wand");
                }
                // add more item names here if needed
                if ("math_axe".startsWith(partialItemName)){
                    completions.add("math_axe");
                }
                if ("walmart_terminator".startsWith(partialItemName)){
                    completions.add("walmart_terminator");
                }
            }
        }

        return completions;
    }
}
