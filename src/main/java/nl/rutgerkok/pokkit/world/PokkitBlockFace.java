package nl.rutgerkok.pokkit.world;

import org.bukkit.block.BlockFace;

public final class PokkitBlockFace {

	public static BlockFace toBukkit(cn.nukkit.math.BlockFace nukkit) {
		return BlockFace.valueOf(nukkit.name());
	}
}
