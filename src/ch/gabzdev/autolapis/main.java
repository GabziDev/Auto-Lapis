package ch.gabzdev.autolapis;

import java.util.ArrayList;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
  public ArrayList<EnchantingInventory> inventories;
  
  public void onEnable() {
    getServer().getPluginManager().registerEvents(new Events(this), (Plugin)this);
    this.inventories = new ArrayList<>();
  }
  
  public void onDisable() {
    for (EnchantingInventory ei : this.inventories)
      ei.setItem(1, null); 
    this.inventories = null;
  }
}
