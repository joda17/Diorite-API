package org.diorite.material.blocks.stony.ore;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.maps.CaseInsensitiveMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "GoldOre" and all its subtypes.
 */
public class GoldOreMat extends OreMat
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 1;
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__GOLD_ORE__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__GOLD_ORE__HARDNESS;

    public static final GoldOreMat GOLD_ORE = new GoldOreMat();

    private static final Map<String, GoldOreMat>    byName = new CaseInsensitiveMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<GoldOreMat> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected GoldOreMat()
    {
        super("GOLD_ORE", 14, "minecraft:gold_ore", "GOLD_ORE", (byte) 0x00);
    }

    protected GoldOreMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type);
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
    public GoldOreMat getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public GoldOreMat getType(final int id)
    {
        return getByID(id);
    }

    /**
     * Returns one of GoldOre sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of GoldOre or null
     */
    public static GoldOreMat getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of GoldOre sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of GoldOre or null
     */
    public static GoldOreMat getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final GoldOreMat element)
    {
        byID.put((byte) element.getType(), element);
        byName.put(element.name(), element);
    }

    @Override
    public GoldOreMat[] types()
    {
        return GoldOreMat.goldOreTypes();
    }

    /**
     * @return array that contains all sub-types of this block.
     */
    public static GoldOreMat[] goldOreTypes()
    {
        return byID.values(new GoldOreMat[byID.size()]);
    }

    static
    {
        GoldOreMat.register(GOLD_ORE);
    }
}
