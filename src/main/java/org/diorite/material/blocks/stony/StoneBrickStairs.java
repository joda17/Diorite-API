package org.diorite.material.blocks.stony;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.Stairs;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class StoneBrickStairs extends BlockMaterialData implements Stairs
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__STONE_BRICK_STAIRS__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__STONE_BRICK_STAIRS__HARDNESS;

    public static final StoneBrickStairs STONE_BRICK_STAIRS = new StoneBrickStairs();

    private static final Map<String, StoneBrickStairs>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<StoneBrickStairs> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected StoneBrickStairs()
    {
        super("STONE_BRICK_STAIRS", 109, "minecraft:stone_brick_stairs", "STONE_BRICK_STAIRS", (byte) 0x00);
    }

    public StoneBrickStairs(final String enumName, final int type)
    {
        super(STONE_BRICK_STAIRS.name(), STONE_BRICK_STAIRS.getId(), STONE_BRICK_STAIRS.getMinecraftId(), enumName, (byte) type);
    }

    public StoneBrickStairs(final int maxStack, final String typeName, final byte type)
    {
        super(STONE_BRICK_STAIRS.name(), STONE_BRICK_STAIRS.getId(), STONE_BRICK_STAIRS.getMinecraftId(), maxStack, typeName, type);
    }

    @Override
    public float getBlastResistance()
    {
        return BLAST_RESISTANCE;
    }

    @Override
    public float getHardness()
    {
        return HARDNESS;
    }

    @Override
    public StoneBrickStairs getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public StoneBrickStairs getType(final int id)
    {
        return getByID(id);
    }

    public static StoneBrickStairs getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static StoneBrickStairs getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final StoneBrickStairs element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        StoneBrickStairs.register(STONE_BRICK_STAIRS);
    }
}