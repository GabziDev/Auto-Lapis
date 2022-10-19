package ch.gabzdev.autolapis;

import java.util.ArrayList;

import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.plugin.java.JavaPlugin;

import ch.gabzdev.autolapis.events.AutoLapis;

public class Main extends JavaPlugin {
	
  public ArrayList<EnchantingInventory> inventories;
  
  public void onEnable() {
	getServer().getPluginManager().registerEvents(new AutoLapis(this), this);
	this.inventories = new ArrayList<>();
	getServer().getConsoleSender().sendMessage("§b=========================");
	getServer().getConsoleSender().sendMessage("§b==>>    §e§kAutoLapis§r§b    <<==");
	getServer().getConsoleSender().sendMessage("§b==>>      §e§k1.2.0§r§b      <<==");
	getServer().getConsoleSender().sendMessage("§b==>>     §e§kGabzDEV§r§b     <<==");
	getServer().getConsoleSender().sendMessage("§b=========================");
  }
  
  public void onDisable() {
    for (EnchantingInventory ei : this.inventories)
      ei.setItem(1, null); 
    this.inventories = null;
  }
}
