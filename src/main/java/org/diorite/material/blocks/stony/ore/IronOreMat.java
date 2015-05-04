package org.diorite.material.blocks.stony.ore;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "IronOre" and all its subtypes.
 */
public class IronOreMat extends OreMat
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 1;
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__IRON_ORE__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__IRON_ORE__HARDNESS;

    public static final IronOreMat IRON_ORE = new IronOreMat();

    private static final Map<String, IronOreMat>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<IronOreMat> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected IronOreMat()
    {
        super("IRON_ORE", 15, "minecraft:iron_ore", "IRON_ORE", (byte) 0x00);
    }

    protected IronOreMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type)
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
    public IronOreMat getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public IronOreMat getType(final int id)
    {
        return getByID(id);
    }

    /**
     * Returns one of IronOre sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of IronOre or null
     */
    public static IronOreMat getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of IronOre sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of IronOre or null
     */
    public static IronOreMat getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final IronOreMat element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        IronOreMat.register(IRON_ORE);
    }
}