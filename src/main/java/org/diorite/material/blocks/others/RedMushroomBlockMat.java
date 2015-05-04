package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "RedMushroomBlock" and all its subtypes.
 */
public class RedMushroomBlockMat extends MushroomBlockMat
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 13;
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__RED_MUSHROOM_BLOCK__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__RED_MUSHROOM_BLOCK__HARDNESS;

    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_PORES_FULL     = new RedMushroomBlockMat();
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_NORTH_WEST = new RedMushroomBlockMat(Type.CAP_NORTH_WEST);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_NORTH      = new RedMushroomBlockMat(Type.CAP_NORTH);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_NORTH_EAST = new RedMushroomBlockMat(Type.CAP_NORTH_EAST);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_WEST       = new RedMushroomBlockMat(Type.CAP_WEST);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP            = new RedMushroomBlockMat(Type.CAP);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_EAST       = new RedMushroomBlockMat(Type.CAP_EAST);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_SOUTH_WEST = new RedMushroomBlockMat(Type.CAP_SOUTH_WEST);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_SOUTH      = new RedMushroomBlockMat(Type.CAP_SOUTH);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_SOUTH_EAST = new RedMushroomBlockMat(Type.CAP_SOUTH_EAST);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_STEAM          = new RedMushroomBlockMat(Type.STEAM);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_CAP_FULL       = new RedMushroomBlockMat(Type.CAP_FULL);
    public static final RedMushroomBlockMat RED_MUSHROOM_BLOCK_STEAM_FULL     = new RedMushroomBlockMat(Type.STEAM_FULL);


    private static final Map<String, RedMushroomBlockMat>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<RedMushroomBlockMat> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    protected RedMushroomBlockMat()
    {
        super("RED_MUSHROOM_BLOCK", 100, "minecraft:red_mushroom_block", Type.PORES_FULL);
    }

    protected RedMushroomBlockMat(final Type type)
    {
        super(RED_MUSHROOM_BLOCK_PORES_FULL.name(), RED_MUSHROOM_BLOCK_PORES_FULL.getId(), RED_MUSHROOM_BLOCK_PORES_FULL.getMinecraftId(), type);
    }

    protected RedMushroomBlockMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type, final Type mushroomType)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type, mushroomType);
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
    public RedMushroomBlockMat getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public RedMushroomBlockMat getType(final int id)
    {
        return getByID(id);
    }

    @Override
    public RedMushroomBlockMat getMushroomType(final Type mushroomType)
    {
        return getByID(mushroomType.getFlag());
    }

    /**
     * Returns one of RedMushroomBlock sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of RedMushroomBlock or null
     */
    public static RedMushroomBlockMat getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of RedMushroomBlock sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of RedMushroomBlock or null
     */
    public static RedMushroomBlockMat getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Returns one of RedMushroomBlock sub-type based on {@link Type}.
     * It will never return null;
     *
     * @param type type of mushroom texture/block.
     *
     * @return sub-type of RedMushroomBlock
     */
    public static RedMushroomBlockMat getRedMushroomBlock(final Type type)
    {
        return getByID(type.getFlag());
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final RedMushroomBlockMat element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_PORES_FULL);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_NORTH_WEST);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_NORTH);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_NORTH_EAST);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_WEST);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_EAST);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_SOUTH_WEST);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_SOUTH);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_SOUTH_EAST);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_STEAM);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_CAP_FULL);
        RedMushroomBlockMat.register(RED_MUSHROOM_BLOCK_STEAM_FULL);
    }
}