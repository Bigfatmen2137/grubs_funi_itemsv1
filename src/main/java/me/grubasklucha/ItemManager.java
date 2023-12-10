package me.grubasklucha;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
public class ItemManager {
    public static ItemStack CreateMagicWand(){
        ItemStack MAGIC_WAND = new ItemStack(Material.NETHERITE_HOE, 1);
        ItemMeta MAGIC_WAND_META = MAGIC_WAND.getItemMeta();
        assert MAGIC_WAND_META != null;
        MAGIC_WAND_META.setUnbreakable(true);
        MAGIC_WAND_META.setDisplayName(ChatColor.AQUA + "{" + ChatColor.RED + "Magic Wand" + ChatColor.AQUA + "}");
        ArrayList<String> WAND_LORE = new ArrayList<String>();
        WAND_LORE.add(ChatColor.DARK_PURPLE + "Pain.");
        MAGIC_WAND_META.setLore(WAND_LORE);
        MAGIC_WAND_META.addEnchant(Enchantment.LOYALTY, 1, false);
        MAGIC_WAND_META.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        MAGIC_WAND_META.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        MAGIC_WAND_META.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        MAGIC_WAND.setItemMeta(MAGIC_WAND_META);

        return MAGIC_WAND;


    }
    public  static ItemStack CreateMathAxe(){
        ItemStack MATH_AXE = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta MATH_AXE_META = MATH_AXE.getItemMeta();
        assert  MATH_AXE_META != null;
        MATH_AXE_META.setUnbreakable(true);
        MATH_AXE_META.setDisplayName(ChatColor.AQUA+"§kd§"+ChatColor.LIGHT_PURPLE+"Math Axe"+ ChatColor.AQUA+"§kd§");
        ArrayList<String> MATH_AXE_LORE = new ArrayList<String>();
        MATH_AXE_LORE.add(ChatColor.YELLOW + "§lRIGHT CLICK§"+ChatColor.WHITE + " to set block "+ ChatColor.LIGHT_PURPLE+"A");
    MATH_AXE_LORE.add(ChatColor.YELLOW + "§lLEFT CLICK§"+ChatColor.WHITE + " to set block "+ ChatColor.RED+"B");
        MATH_AXE_LORE.add(ChatColor.GREEN + "Then use /mathaxefill <material type> command to fill the area!");
        MATH_AXE_LORE.add(ChatColor.RED+" (Works kinda like the //wand or /fill command)");
        MATH_AXE_LORE.add(ChatColor.DARK_BLUE+"§oMy head hurts.");
        MATH_AXE_META.setLore(MATH_AXE_LORE);
        MATH_AXE_META.addEnchant(Enchantment.LOYALTY, 1, false);
        MATH_AXE_META.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        MATH_AXE_META.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        MATH_AXE_META.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        MATH_AXE.setItemMeta(MATH_AXE_META);

        return MATH_AXE;
    }
    public  static ItemStack CreateWalmartTerminator() {
        int arrows = 1;
        ItemStack WALMART_TERMINATOR = new ItemStack(Material.BOW, 1);
        ItemMeta TERMINATOR_META = WALMART_TERMINATOR.getItemMeta();
        assert TERMINATOR_META != null;
        TERMINATOR_META.setUnbreakable(true);
        TERMINATOR_META.setDisplayName(ChatColor.BLUE + "Walmart" + ChatColor.GOLD + " Terminator");
        ArrayList<String> TERMINATOR_LORE = new ArrayList<>();
        TERMINATOR_LORE.add(ChatColor.GRAY + "Shortbow - Instantly Shoots!");
        TERMINATOR_LORE.add(ChatColor.GRAY + "Shoots " + ChatColor.RED + Integer.toString(arrows) + ChatColor.GRAY + " arrows at once!");
        TERMINATOR_LORE.add("");
        TERMINATOR_LORE.add("A great Florida Man once wielded this bow,");
        TERMINATOR_LORE.add("but he died in a Walmart fight with "+ ChatColor.RED + "Necron.");
        TERMINATOR_META.setLore(TERMINATOR_LORE);
        TERMINATOR_META.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        WALMART_TERMINATOR.setItemMeta(TERMINATOR_META);

        return WALMART_TERMINATOR;

    }
}
