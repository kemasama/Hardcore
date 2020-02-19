package kema.hardcore.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem {
	private ItemStack item;
	public CustomItem(Material type) {
		item = new ItemStack(type);
	}

	public CustomItem addEnchantment(Enchantment enchantment, int level) {
		item.addEnchantment(enchantment, level);

		return this;
	}
	public CustomItem addUnsafeEnchantment(Enchantment enchantment, int level) {
		item.addUnsafeEnchantment(enchantment, level);

		return this;
	}
	public CustomItem setName(String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);

		return this;
	}

	public ItemStack toItem() {
		return item;
	}
	public ItemStack toItem(int amount) {
		item.setAmount(amount);
		return item;
	}
}
