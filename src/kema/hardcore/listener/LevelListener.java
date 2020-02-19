package kema.hardcore.listener;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

public class LevelListener implements Listener {
	@EventHandler
	public void onLevelChange(PlayerLevelChangeEvent event) {
		if (event.getNewLevel() > event.getOldLevel()) {
			Player pl = event.getPlayer();

			if (event.getNewLevel() % 10 == 0) {
				pl.getWorld().dropItem(pl.getLocation(), getItem());
			}

		}
	}

	public ItemStack getItem() {
		ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);

		EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();

		meta.addStoredEnchant(Enchantment.values()[getRandom(Enchantment.values().length)], 1, true);

		item.setItemMeta(meta);

		return item;
	}

	public int getRandom(int src) {
		return (new Random(System.currentTimeMillis())).nextInt(src);
	}
}
