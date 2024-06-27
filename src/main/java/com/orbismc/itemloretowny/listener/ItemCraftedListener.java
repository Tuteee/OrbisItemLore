package com.orbismc.itemloretowny.listener;

import com.orbismc.itemloretowny.manager.ItemLoreManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Sound;
import org.bukkit.Location;

public class ItemCraftedListener implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        ItemStack result = event.getCurrentItem();
        if (result != null) {
            Player player = (Player) event.getWhoClicked();
            Location location = player.getLocation();
            ItemLoreManager.applyLore(result, (Player) event.getWhoClicked());
            player.playSound(location, Sound.BLOCK_ANVIL_USE, 1.0f, 0.3f);
        }
    }
}
