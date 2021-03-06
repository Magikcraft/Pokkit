package nl.rutgerkok.pokkit.world.biome;

import org.bukkit.block.Biome;

public class PokkitBiome {

    public static Biome toBukkit(int id) {
        switch (id) {
            case 1:
                return Biome.PLAINS;
            case 2:
                return Biome.DESERT;
            case 3:
                return Biome.MOUNTAINS;
            case 4:
                return Biome.FOREST;
            case 5:
                return Biome.TAIGA;
            case 6:
                return Biome.SWAMP;
            case 7:
                return Biome.RIVER;
            case 8:
                return Biome.NETHER;
            case 9:
                return Biome.THE_END;
            case 10:
                return Biome.FROZEN_OCEAN;
            case 11:
                return Biome.FROZEN_RIVER;
            case 12:
                return Biome.SNOWY_TUNDRA;
            case 14:
                return Biome.MUSHROOM_FIELDS;
            case 15:
                return Biome.MUSHROOM_FIELD_SHORE;
            case 16:
                return Biome.BEACH;
            case 17:
                return Biome.DESERT_HILLS;
            case 18:
                return Biome.WOODED_HILLS;
            case 19:
                return Biome.TAIGA_HILLS;
            case 20:
                return Biome.MOUNTAIN_EDGE;
            case 21:
                return Biome.JUNGLE;
            case 22:
                return Biome.JUNGLE_HILLS;
            case 23:
                return Biome.JUNGLE_EDGE;
            case 24:
                return Biome.DEEP_OCEAN;
            case 25:
                return Biome.STONE_SHORE;
            case 26:
                return Biome.SNOWY_BEACH;
            case 27:
                return Biome.BIRCH_FOREST;
            case 28:
                return Biome.BIRCH_FOREST_HILLS;
            case 29:
                return Biome.DARK_FOREST;
            case 30:
                return Biome.SNOWY_TAIGA;
            case 31:
                return Biome.SNOWY_TAIGA_HILLS;
            case 32:
                return Biome.GIANT_TREE_TAIGA;
            case 33:
                return Biome.GIANT_TREE_TAIGA_HILLS;
            case 34:
                return Biome.WOODED_MOUNTAINS;
            case 35:
                return Biome.SAVANNA;
            case 36:
                return Biome.SAVANNA_PLATEAU;
            case 37:
                return Biome.BADLANDS;
            case 38:
                return Biome.WOODED_BADLANDS_PLATEAU;
            case 39:
                return Biome.BADLANDS_PLATEAU;
            case 129:
                return Biome.SUNFLOWER_PLAINS;
            case 130:
                return Biome.DESERT_LAKES;
            case 131:
                return Biome.GRAVELLY_MOUNTAINS;
            case 132:
                return Biome.FLOWER_FOREST;
            case 133:
                return Biome.TAIGA_MOUNTAINS;
            case 134:
                return Biome.SWAMP_HILLS;
            case 140:
                return Biome.ICE_SPIKES;
            case 149:
                return Biome.MODIFIED_JUNGLE;
            case 151:
                return Biome.MODIFIED_JUNGLE_EDGE;
            case 155:
                return Biome.TALL_BIRCH_FOREST;
            case 156:
                return Biome.TALL_BIRCH_HILLS;
            case 157:
                return Biome.DARK_FOREST_HILLS;
            case 158:
                return Biome.SNOWY_TAIGA_MOUNTAINS;
            case 160:
                return Biome.GIANT_SPRUCE_TAIGA_HILLS;
            case 162:
                return Biome.MODIFIED_GRAVELLY_MOUNTAINS;
            case 163:
                return Biome.SHATTERED_SAVANNA;
            case 164:
                return Biome.SHATTERED_SAVANNA_PLATEAU;
            case 165:
                return Biome.ERODED_BADLANDS;
            case 166:
                return Biome.MODIFIED_WOODED_BADLANDS_PLATEAU;
            case 167:
                return Biome.MODIFIED_BADLANDS_PLATEAU;
            default:
                return Biome.OCEAN;
        }
    }

    public static int toNukkit(Biome biome) {
        switch (biome) {
            case PLAINS:
                return 1;
            case DESERT:
                return 2;
            case MOUNTAINS:
                return 3;
            case FOREST:
                return 4;
            case TAIGA:
                return 5;
            case SWAMP:
                return 6;
            case RIVER:
                return 7;
            case NETHER:
                return 8;
            case THE_END:
                return 9;
            case FROZEN_OCEAN:
                return 10;
            case FROZEN_RIVER:
                return 11;
            case SNOWY_TUNDRA:
                return 12;
            case MUSHROOM_FIELDS:
                return 14;
            case MUSHROOM_FIELD_SHORE:
                return 15;
            case BEACH:
                return 16;
            case DESERT_HILLS:
                return 17;
            case WOODED_HILLS:
                return 18;
            case TAIGA_HILLS:
                return 19;
            case MOUNTAIN_EDGE:
                return 20;
            case JUNGLE:
                return 21;
            case JUNGLE_HILLS:
                return 22;
            case JUNGLE_EDGE:
                return 23;
            case DEEP_OCEAN:
                return 24;
            case STONE_SHORE:
                return 25;
            case SNOWY_BEACH:
                return 26;
            case BIRCH_FOREST:
                return 27;
            case BIRCH_FOREST_HILLS:
                return 28;
            case DARK_FOREST:
                return 29;
            case SNOWY_TAIGA:
                return 30;
            case SNOWY_TAIGA_HILLS:
                return 31;
            case GIANT_TREE_TAIGA:
                return 32;
            case GIANT_TREE_TAIGA_HILLS:
                return 33;
            case WOODED_MOUNTAINS:
                return 34;
            case SAVANNA:
                return 35;
            case SAVANNA_PLATEAU:
                return 36;
            case BADLANDS:
                return 37;
            case WOODED_BADLANDS_PLATEAU:
                return 38;
            case BADLANDS_PLATEAU:
                return 39;
            case SUNFLOWER_PLAINS:
                return 129;
            case DESERT_LAKES:
                return 130;
            case GRAVELLY_MOUNTAINS:
                return 131;
            case FLOWER_FOREST:
                return 132;
            case TAIGA_MOUNTAINS:
                return 133;
            case SWAMP_HILLS:
                return 134;
            case ICE_SPIKES:
                return 140;
            case MODIFIED_JUNGLE:
                return 149;
            case MODIFIED_JUNGLE_EDGE:
                return 151;
            case TALL_BIRCH_FOREST:
                return 155;
            case TALL_BIRCH_HILLS:
                return 156;
            case DARK_FOREST_HILLS:
                return 157;
            case SNOWY_TAIGA_MOUNTAINS:
                return 158;
            case GIANT_SPRUCE_TAIGA_HILLS:
                return 160;
            case MODIFIED_GRAVELLY_MOUNTAINS:
                return 162;
            case SHATTERED_SAVANNA:
                return 163;
            case SHATTERED_SAVANNA_PLATEAU:
                return 164;
            case ERODED_BADLANDS:
                return 165;
            case MODIFIED_WOODED_BADLANDS_PLATEAU:
                return 166;
            case MODIFIED_BADLANDS_PLATEAU:
                return 167;
            default:
                return 0;
        }
    }
}
