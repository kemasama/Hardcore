package kema.hardcore.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import kema.hardcore.Game;
import kema.hardcore.util.CustomItem;

public class JoinListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();

		if (p.getGameMode().equals(GameMode.SPECTATOR)) {
			event.setJoinMessage("");
		}else {
			event.setJoinMessage("§b" + p.getName() + " §eが参加しました!");
		}

		if (!p.hasPlayedBefore()) {
			try {
				p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40.0);
				p.setHealth(40.0);
			} catch (Exception e) {
				e.printStackTrace();
			}

			PlayerInventory inv = p.getInventory();
			inv.setItem(0, new CustomItem(Material.STONE_SWORD).addEnchantment(Enchantment.DAMAGE_ALL, 1).toItem());
			inv.setItem(1, new CustomItem(Material.STONE_PICKAXE).addEnchantment(Enchantment.DIG_SPEED, 3).toItem());
			inv.setItem(2, new CustomItem(Material.STONE_AXE).addEnchantment(Enchantment.DIG_SPEED, 3).toItem());
			inv.setItem(3, new CustomItem(Material.STONE_SPADE).addEnchantment(Enchantment.DIG_SPEED, 3).toItem());
			//inv.setItem(4, new CustomItem(Material.STONE_HOE).toItem());
			inv.addItem(new ItemStack(Material.BREAD, 8));

			/*
			inv.setHelmet(new CustomItem(Material.LEATHER_HELMET).addEnchantment(Enchantment.DURABILITY, 1).toItem());
			inv.setChestplate(new CustomItem(Material.LEATHER_CHESTPLATE).addEnchantment(Enchantment.DURABILITY, 1).toItem());
			inv.setLeggings(new CustomItem(Material.LEATHER_LEGGINGS).addEnchantment(Enchantment.DURABILITY, 1).toItem());
			inv.setBoots(new CustomItem(Material.LEATHER_BOOTS).addEnchantment(Enchantment.PROTECTION_FALL, 1).toItem());
			*/

			p.setNoDamageTicks(20 * 10);

		}

		for (Player pl : Bukkit.getOnlinePlayers()) {
			if (pl.getGameMode().equals(GameMode.SPECTATOR)) {
				Game.getHideHelper().hide(pl, p);
			}
		}

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();

		if (p.getGameMode().equals(GameMode.SPECTATOR)) {
			event.setQuitMessage("");
		}else {
			event.setQuitMessage("§b" + p.getName() + " §eが退出しました!");
		}
	}

}
