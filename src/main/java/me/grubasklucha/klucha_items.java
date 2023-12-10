package me.grubasklucha;
import org.bukkit.plugin.java.JavaPlugin;

public class klucha_items extends JavaPlugin {
    // This method is called when your plugin is enabled
    @Override
    public void onEnable() {
        getLogger().info("klucha_items enabled!");
        // register events
        try{
            getServer().getPluginManager().registerEvents(new WandListener(), this);
            getLogger().info("WandListener works!");
        } catch (Exception err) {
            getLogger().info("WandListener nie dziala!");
        }
        try{
            getServer().getPluginManager().registerEvents(new MathAxeListener(), this);
            getLogger().info("MathAxeListener works!");
        } catch(Exception err) {
            getLogger().info("MathAxeListener nie dziala!");
        }
        try{
            getServer().getPluginManager().registerEvents(new WalmartTerminatorListener(), this);
            getLogger().info("Walmart Terminator works!");
        } catch(Exception err) {
            getLogger().info("Walmart Terminator nie dziala!");
        }

        getCommand("test").setExecutor(new CommandManager());
        getCommand("givefunnyitem").setExecutor(new CommandManager());
    }

    // This method is called when your plugin is disabled
    @Override
    public void onDisable() {
        getLogger().info("klucha_items disabled!");
    }


}

