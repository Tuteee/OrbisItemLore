package com.orbismc.itemloretowny.listener;

import com.orbismc.itemloretowny.manager.ItemLoreManager;
import com.orbismc.itemloretowny.util.MaterialUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.List;

public class ItemCraftedListener implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        ItemStack result = event.getCurrentItem();
        if (result != null) {
            Player player = (Player) event.getWhoClicked();
            Location location = player.getLocation();
            
            // Check if the crafted item is armor, tool, crossbow, bow, or shield
            if (isCraftedItemValid(result.getType())) {
                ItemLoreManager.applyLore(result, player);
                player.playSound(location, Sound.BLOCK_ANVIL_USE, 1.0f, 0.3f); // Play BLOCK_ANVIL_USE sound
            }
        }
    }
    
    // Method to check if the crafted item type is valid (armor, tool, crossbow, bow, or shield)
    private boolean isCraftedItemValid(Material itemType) {
        List<Material> targetMaterials = MaterialUtil.targetMaterials;
        return targetMaterials.contains(itemType);
    }
}
