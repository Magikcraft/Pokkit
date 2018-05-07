package nl.rutgerkok.pokkit.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import nl.rutgerkok.pokkit.Pokkit;
import nl.rutgerkok.pokkit.blockstate.PokkitBlockState;
import nl.rutgerkok.pokkit.item.PokkitItemStack;
import nl.rutgerkok.pokkit.material.PokkitMaterialData;
import nl.rutgerkok.pokkit.metadata.BlockMetadataStore;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.craftbukkit.v1_99_R9.CraftServer;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import cn.nukkit.block.BlockAir;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBlock;
import cn.nukkit.level.biome.EnumBiome;

/**
 * Converts between Nukkit and Bukkit blocks.
 *
 */
public final class PokkitBlock implements Block {

	public static final PokkitBlock toBukkit(cn.nukkit.block.Block nukkit) {
		if (nukkit == null) {
			return null;
		}
		return new PokkitBlock(nukkit);
	}

	public static final cn.nukkit.block.Block toNukkit(Block block) {
		if (block == null) {
			return null;
		}
		return ((PokkitBlock) block).nukkit;
	}

	private cn.nukkit.block.Block nukkit;

	/**
	 * Allows for changed drops.
	 */
	private List<ItemStack> drops;

	private PokkitBlock(cn.nukkit.block.Block nukkit) {
		this.nukkit = Objects.requireNonNull(nukkit, "nukkit");
	}

	@Override
	public boolean breakNaturally() {
		return nukkit.level.useBreakOn(nukkit) != null;
	}

	@Override
	public boolean breakNaturally(ItemStack tool) {
		return nukkit.level.useBreakOn(nukkit, PokkitItemStack.toNukkitCopy(tool)) != null;
	}

	@Override
	public Biome getBiome() {
		throw Pokkit.unsupported();

	}

	private BlockMetadataStore getBlockMetadata() {
		return ((CraftServer) Bukkit.getServer()).getMetadata().getBlockMetadata();
	}

	@Override
	public int getBlockPower() {
		throw Pokkit.unsupported();

	}

	@Override
	public int getBlockPower(BlockFace face) {
		throw Pokkit.unsupported();

	}

	@Override
	public Chunk getChunk() {
		return PokkitChunk.of(this);
	}

	@Override
	public byte getData() {
		PokkitMaterialData materialData = PokkitMaterialData.fromNukkit(nukkit.toItem());
		return (byte) materialData.getBukkitDamage();
	}

	@Override
	public Collection<ItemStack> getDrops() {
		return getDrops0(null);
	}

	@Override
	public Collection<ItemStack> getDrops(ItemStack tool) {
		return getDrops0(PokkitItemStack.toNukkitCopy(tool));
	}

	private Collection<ItemStack> getDrops0(cn.nukkit.item.Item item) {
		if (this.drops != null) {
			return this.drops;
		}

		if (item == null) {
			item = new ItemBlock(new BlockAir(), 0, 0);
		}

		Item[] drops = nukkit.getDrops(item);
		List<ItemStack> result = new ArrayList<>();
		for (Item drop : drops) {
			PokkitMaterialData materialData = PokkitMaterialData.fromNukkit(drop);
			ItemStack stack = new ItemStack(materialData.getBukkitMaterial(), drop.getCount(), materialData.getBukkitDamage());
			result.add(stack);
		}
		this.drops = result;
		return result;
	}

	@Override
	public BlockFace getFace(Block block) {
		for (BlockFace face : BlockFace.values()) {
			if (block.getX() == this.getX() + face.getModX() && block.getY() == this.getY() + face.getModY()
					&& block.getZ() == this.getZ() + face.getModZ()) {
				return face;
			}
		}
		return null;
	}

	@Override
	public double getHumidity() {
		return 0.15; // Seems to be removed from Nukkit
	}

	@Override
	public byte getLightFromBlocks() {
		return (byte) nukkit.getLightLevel(); // TODO: I think this is wrong, but there isn't any way to get the light emitted from blocks
	}

	@Override
	public byte getLightFromSky() {
		return (byte) nukkit.getLightLevel(); // TODO: Same thing as above
	}

	@Override
	public byte getLightLevel() {
		return (byte) nukkit.getLightLevel();
	}

	@Override
	public Location getLocation() {
		return new Location(PokkitWorld.toBukkit(nukkit.level), nukkit.x, nukkit.y, nukkit.z);
	}

	@Override
	public Location getLocation(Location loc) {
		loc.setWorld(PokkitWorld.toBukkit(nukkit.level));
		loc.setX(nukkit.x);
		loc.setY(nukkit.y);
		loc.setZ(nukkit.z);
		loc.setYaw(0f);
		loc.setPitch(0f);
		return loc;
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return getBlockMetadata().getMetadata(this, metadataKey);
	}

	@Override
	public PistonMoveReaction getPistonMoveReaction() {
		throw Pokkit.unsupported();

	}

	@Override
	public Block getRelative(BlockFace face) {
		return getRelative(face.getModX(), face.getModY(), face.getModZ());
	}

	@Override
	public Block getRelative(BlockFace face, int distance) {
		return getRelative(face.getModX() * distance, face.getModY() * distance, face.getModZ() * distance);
	}

	@Override
	public Block getRelative(int modX, int modY, int modZ) {
		return getWorld().getBlockAt(getX() + modX, getY() + modY, getZ() + modZ);
	}

	@Override
	public BlockState getState() {
		return PokkitBlockState.getBlockState(this);
	}

	@Override
	public double getTemperature() {
		int biomeId = nukkit.getLevel().getBiomeId((int) nukkit.x, (int) nukkit.z);
		@SuppressWarnings("deprecation")
		cn.nukkit.level.biome.Biome biome = EnumBiome.getBiome(biomeId);
		if (biome != null && biome.isFreezing()) {
			return 0.1;
		}
		return 0.6;
	}

	@Override
	public Material getType() {
		return PokkitMaterialData.fromNukkit(nukkit.toItem()).getBukkitMaterial();
	}

	/**
	 * Gets the material data in one call.
	 *
	 * @return The material data.
	 */
	public MaterialData getTypeData() {
		return PokkitMaterialData.fromNukkit(nukkit.toItem()).toBukkit();
	}

	@Override
	public int getTypeId() {
		@SuppressWarnings("deprecation")
		int typeId = getType().getId();
		return typeId;
	}

	@Override
	public PokkitWorld getWorld() {
		return PokkitWorld.toBukkit(nukkit.level);
	}

	@Override
	public int getX() {
		return (int) nukkit.x;
	}

	@Override
	public int getY() {
		return (int) nukkit.y;
	}

	@Override
	public int getZ() {
		return (int) nukkit.z;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return getBlockMetadata().hasMetadata(this, metadataKey);
	}

	@Override
	public boolean isBlockFaceIndirectlyPowered(BlockFace face) {
		throw Pokkit.unsupported();

	}

	@Override
	public boolean isBlockFacePowered(BlockFace face) {
		throw Pokkit.unsupported();

	}

	@Override
	public boolean isBlockIndirectlyPowered() {
		return nukkit.level.isBlockIndirectlyGettingPowered(nukkit) > 0;
	}

	@Override
	public boolean isBlockPowered() {
		return nukkit.level.isBlockPowered(nukkit);
	}

	@Override
	public boolean isEmpty() {
		return nukkit.getId() == cn.nukkit.block.Block.AIR;
	}

	@Override
	public boolean isLiquid() {
		return nukkit instanceof cn.nukkit.block.BlockLiquid;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		getBlockMetadata().removeMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public void setBiome(Biome bio) {
		throw Pokkit.unsupported();

	}

	@Override
	public void setData(byte data) {
		setData(data, true);
	}

	@Override
	public void setData(byte data, boolean applyPhysics) {
		if (data == getData()) {
			return;
		}

		PokkitMaterialData materialData = PokkitMaterialData.fromBukkit(getType(), data);
		setType0(materialData, applyPhysics);
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		getBlockMetadata().setMetadata(this, metadataKey, newMetadataValue);
	}

	@Override
	public void setType(Material type) {
		setType(type, true);
	}

	@Override
	public void setType(Material type, boolean applyPhysics) {
		if (type == getType()) {
			return;
		}
		if (type == null) {
			type = Material.AIR;
		}

		PokkitMaterialData materialData = PokkitMaterialData.fromBukkit(type, getData());
		setType0(materialData, applyPhysics);
	}

	private void setType0(PokkitMaterialData materialData, boolean applyPhysics) {
		int nukkitId = materialData.getNukkitId();
		int nukkitData = materialData.getNukkitDamage();
		nukkit.level.setBlock(nukkit, cn.nukkit.block.Block.get(nukkitId, nukkitData), false, applyPhysics);

		// Update block reference
		nukkit = nukkit.level.getBlock(nukkit);
	}

	/**
	 * Sets a material and data at the same time.
	 *
	 * @param materialData
	 *            The material and data.
	 * @param applyPhysics
	 *            Whether a physics update must be performed.
	 */
	public void setTypeAndData(MaterialData materialData, boolean applyPhysics) {
		setType0(PokkitMaterialData.fromBukkit(materialData), applyPhysics);
	}

	@Override
	@Deprecated
	public boolean setTypeId(int typeId) {
		return setTypeId(typeId, true);
	}

	@Override
	@Deprecated
	public boolean setTypeId(int typeId, boolean applyPhysics) {
		Material material = Material.getMaterial(typeId);
		if (material == null) {
			return false;
		}
		setType(material, applyPhysics);
		return true;
	}

	@Override
	@Deprecated
	public boolean setTypeIdAndData(int typeId, byte data, boolean applyPhysics) {
		Material type = Material.getMaterial(typeId);
		if (type == null) {
			return false;
		}

		PokkitMaterialData materialData = PokkitMaterialData.fromBukkit(type, data);
		setType0(materialData, applyPhysics);
		return true;
	}

}
