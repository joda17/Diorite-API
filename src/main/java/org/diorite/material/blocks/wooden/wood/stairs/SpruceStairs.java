package org.diorite.material.blocks.wooden.wood.stairs;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.blocks.wooden.WoodType;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class SpruceStairs extends WoodenStairs
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__SPRUCE_STAIRS__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__SPRUCE_STAIRS__HARDNESS;

    public static final SpruceStairs SPRUCE_STAIRS = new SpruceStairs();

    private static final Map<String, SpruceStairs>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<SpruceStairs> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected SpruceStairs()
    {
        super("SPRUCE_STAIRS", 134, "minecraft:spruce_stairs", "SPRUCE_STAIRS", WoodType.SPRUCE);
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
    public SpruceStairs getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public SpruceStairs getType(final int id)
    {
        return getByID(id);
    }

    public static SpruceStairs getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static SpruceStairs getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final SpruceStairs element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        SpruceStairs.register(SPRUCE_STAIRS);
    }
}