package kema.hardcore.api;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class RankFormat {
	private String rank;
	private String color;
	private String guildTag;

	public RankFormat() {

	}

	public String format(Player p) {
		String prefix;
		String rankColor = (color == null) ? "§c" : ChatColor.valueOf(color).toString();

		if (rank == null) {
			rank = "none";
		}

		switch (rank.toLowerCase()) {
		case "admin":
			prefix = "§c[ADMIN]" + p.getName();
			break;
		case "moderator":
			prefix = "§2[MOD] " + p.getName();
			break;
		case "helper":
			prefix = "§9[HELPER] " + p.getName();
			break;
		case "youtuber":
			prefix = "§6[YT] " + p.getName();
			break;
		case "mvp_plus":
			prefix = "§b[MVP" + rankColor + "+§b] " + p.getName();
			break;
		case "mvp":
			prefix = "§b[MVP] " + p.getName();
			break;
		case "vip_plus":
			prefix = "§a[VIP§6+§a] " + p.getName();
			break;
		case "vip":
			prefix = "§a[VIP] " + p.getName();
			break;
		default:
			prefix = "§7" + p.getName();
			break;
		}

		if (guildTag == null) {
			return prefix;
		}else {
			return prefix + " " + guildTag;
		}
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGuildTag() {
		return guildTag;
	}

	public void setGuildTag(String guildTag) {
		this.guildTag = guildTag;
	}

}