package org.diorite.material.blocks.wooden.wood;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.blocks.SlabTypeMat;
import org.diorite.material.blocks.wooden.WoodTypeMat;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "WoodenSlab" and all its subtypes.
 */
public class WoodenSlabMat extends WoodSlabMat
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 12;
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__WOODEN_SLAB__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__WOODEN_SLAB__HARDNESS;

    public static final WoodenSlabMat WOODEN_SLAB_OAK      = new WoodenSlabMat();
    public static final WoodenSlabMat WOODEN_SLAB_SPRUCE   = new WoodenSlabMat(WoodTypeMat.SPRUCE, SlabTypeMat.BOTTOM);
    public static final WoodenSlabMat WOODEN_SLAB_BIRCH    = new WoodenSlabMat(WoodTypeMat.BIRCH, SlabTypeMat.BOTTOM);
    public static final WoodenSlabMat WOODEN_SLAB_JUNGLE   = new WoodenSlabMat(WoodTypeMat.JUNGLE, SlabTypeMat.BOTTOM);
    public static final WoodenSlabMat WOODEN_SLAB_DARK_OAK = new WoodenSlabMat(WoodTypeMat.DARK_OAK, SlabTypeMat.BOTTOM);
    public static final WoodenSlabMat WOODEN_SLAB_ACACIA   = new WoodenSlabMat(WoodTypeMat.ACACIA, SlabTypeMat.BOTTOM);

    public static final WoodenSlabMat WOODEN_SLAB_OAK_UPPER      = new WoodenSlabMat(WoodTypeMat.OAK, SlabTypeMat.UPPER);
    public static final WoodenSlabMat WOODEN_SLAB_SPRUCE_UPPER   = new WoodenSlabMat(WoodTypeMat.SPRUCE, SlabTypeMat.UPPER);
    public static final WoodenSlabMat WOODEN_SLAB_BIRCH_UPPER    = new WoodenSlabMat(WoodTypeMat.BIRCH, SlabTypeMat.UPPER);
    public static final WoodenSlabMat WOODEN_SLAB_JUNGLE_UPPER   = new WoodenSlabMat(WoodTypeMat.JUNGLE, SlabTypeMat.UPPER);
    public static final WoodenSlabMat WOODEN_SLAB_DARK_OAK_UPPER = new WoodenSlabMat(WoodTypeMat.DARK_OAK, SlabTypeMat.UPPER);
    public static final WoodenSlabMat WOODEN_SLAB_ACACIA_UPPER   = new WoodenSlabMat(WoodTypeMat.ACACIA, SlabTypeMat.UPPER);

    private static final Map<String, WoodenSlabMat>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<WoodenSlabMat> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected WoodenSlabMat()
    {
        super("WOODEN_SLAB", 126, "minecraft:wooden_slab", "OAK", WoodTypeMat.OAK, SlabTypeMat.BOTTOM);
    }

    @SuppressWarnings("MagicNumber")
    public WoodenSlabMat(final WoodTypeMat woodType, final SlabTypeMat slabType)
    {
        super(WOODEN_SLAB_OAK.name(), WOODEN_SLAB_OAK.getId(), WOODEN_SLAB_OAK.getMinecraftId(), woodType.name() + (slabType.getFlag() == 0 ? "" : slabType.name()), woodType, slabType);
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
    public WoodenSlabMat getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public WoodenSlabMat getType(final int id)
    {
        return getByID(id);
    }

    @Override
    public WoodenSlabMat getWoodType(final WoodTypeMat woodType)
    {
        return getByID(combine(woodType, this.slabType));
    }

    /**
     * Returns one of WoodenSlab sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of WoodenSlab or null
     */
    public static WoodenSlabMat getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of WoodenSlab sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of WoodenSlab or null
     */
    public static WoodenSlabMat getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Returns one of WoodenSlab sub-type based on {@link WoodTypeMat} and {@link SlabTypeMat}
     * It will never return null.
     *
     * @param woodType type of wood.
     * @param slabType type of slab.
     *
     * @return sub-type of WoodenSlab
     */
    public static WoodenSlabMat getWoodenSlab(final WoodTypeMat woodType, final SlabTypeMat slabType)
    {
        return getByID(combine(woodType, slabType));
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final WoodenSlabMat element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        WoodenSlabMat.register(WOODEN_SLAB_OAK);
        WoodenSlabMat.register(WOODEN_SLAB_SPRUCE);
        WoodenSlabMat.register(WOODEN_SLAB_BIRCH);
        WoodenSlabMat.register(WOODEN_SLAB_JUNGLE);
        WoodenSlabMat.register(WOODEN_SLAB_DARK_OAK);
        WoodenSlabMat.register(WOODEN_SLAB_ACACIA);
        WoodenSlabMat.register(WOODEN_SLAB_OAK_UPPER);
        WoodenSlabMat.register(WOODEN_SLAB_SPRUCE_UPPER);
        WoodenSlabMat.register(WOODEN_SLAB_BIRCH_UPPER);
        WoodenSlabMat.register(WOODEN_SLAB_JUNGLE_UPPER);
        WoodenSlabMat.register(WOODEN_SLAB_DARK_OAK_UPPER);
        WoodenSlabMat.register(WOODEN_SLAB_ACACIA_UPPER);
    }
}