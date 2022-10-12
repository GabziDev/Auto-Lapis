package ch.gabzdev.autolapis;

import org.bukkit.DyeColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.EnchantingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

public class Events implements Listener {
  private main plugin;
  
  private ItemStack lapis;
  
  public Events(main plugin) {
    this.plugin = plugin;
    Dye d = new Dye();
    d.setColor(DyeColor.BLUE);
    this.lapis = d.toItemStack();
    this.lapis.setAmount(23);
  }
  
  @EventHandler
  public void openInventoryEvent(InventoryOpenEvent e) {
    if (e.getInventory() instanceof EnchantingInventory && (
      e.getPlayer().hasPermission("gabzdev.autolapis") || 
      e.getPlayer().isOp() || e.getPlayer().hasPermission("*"))) {
      e.getInventory().setItem(1, this.lapis);
      this.plugin.inventories.add((EnchantingInventory)e
          .getInventory());
    } 
  }
  
  @EventHandler
  public void closeInventoryEvent(InventoryCloseEvent e) {
    if (e.getInventory() instanceof EnchantingInventory && 
      this.plugin.inventories.contains(e
        .getInventory())) {
      e.getInventory().setItem(1, null);
      this.plugin.inventories.remove(e
          .getInventory());
    } 
  }
  
  @EventHandler
  public void inventoryClickEvent(InventoryClickEvent e) {
    if (e.getClickedInventory() instanceof EnchantingInventory && 
      this.plugin.inventories.contains(e
        .getInventory()) && 
      e.getSlot() == 1)
      e.setCancelled(true); 
  }
  
  @EventHandler
  public void enchantItemEvent(EnchantItemEvent e) {
    if (this.plugin.inventories.contains(e
        .getInventory()))
      e.getInventory().setItem(1, this.lapis); 
  }
}
