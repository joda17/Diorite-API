package org.diorite.material.blocks.wooden.wood.stairs;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.blocks.wooden.WoodType;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class AcaciaStairs extends WoodenStairs
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__ACACIA_STAIRS__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__ACACIA_STAIRS__HARDNESS;

    public static final AcaciaStairs ACACIA_STAIRS = new AcaciaStairs();

    private static final Map<String, AcaciaStairs>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<AcaciaStairs> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected AcaciaStairs()
    {
        super("ACACIA_STAIRS", 163, "minecraft:acacia_stairs", "ACACIA_STAIRS", WoodType.ACACIA);
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
    public AcaciaStairs getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public AcaciaStairs getType(final int id)
    {
        return getByID(id);
    }

    public static AcaciaStairs getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static AcaciaStairs getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final AcaciaStairs element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        AcaciaStairs.register(ACACIA_STAIRS);
    }
}