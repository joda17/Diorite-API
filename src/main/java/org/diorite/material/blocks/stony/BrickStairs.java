package org.diorite.material.blocks.stony;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.Stairs;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class BrickStairs extends BlockMaterialData implements Stairs
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__BRICK_STAIRS__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__BRICK_STAIRS__HARDNESS;

    public static final BrickStairs BRICK_STAIRS = new BrickStairs();

    private static final Map<String, BrickStairs>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<BrickStairs> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected BrickStairs()
    {
        super("BRICK_STAIRS", 108, "minecraft:brick_stairs", "BRICK_STAIRS", (byte) 0x00);
    }

    public BrickStairs(final String enumName, final int type)
    {
        super(BRICK_STAIRS.name(), BRICK_STAIRS.getId(), BRICK_STAIRS.getMinecraftId(), enumName, (byte) type);
    }

    public BrickStairs(final int maxStack, final String typeName, final byte type)
    {
        super(BRICK_STAIRS.name(), BRICK_STAIRS.getId(), BRICK_STAIRS.getMinecraftId(), maxStack, typeName, type);
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
    public BrickStairs getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public BrickStairs getType(final int id)
    {
        return getByID(id);
    }

    public static BrickStairs getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static BrickStairs getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final BrickStairs element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        BrickStairs.register(BRICK_STAIRS);
    }
}