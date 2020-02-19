package kema.hardcore.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class OreListener implements Listener {
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Material type = event.getBlock().getType();

		switch (type) {
		case COAL_ORE:
			event.setExpToDrop(3);
			event.setDropItems(false);
			event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.COAL));
			break;
		case IRON_ORE:
			event.setExpToDrop(5);
			event.setDropItems(false);
			event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT));
			break;
		case LAPIS_ORE:
			event.setExpToDrop(8);
			event.setDropItems(false);
			event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.LAPIS_LAZULI));
			break;
		case REDSTONE_ORE:
			event.setExpToDrop(8);
			event.setDropItems(false);
			event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.REDSTONE));
			break;
		case DIAMOND_ORE:
			event.setExpToDrop(10);
			event.setDropItems(false);
			event.getBlock().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.DIAMOND));
			break;
		default:
			break;
		}
	}
}
