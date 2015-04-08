package org.diorite.material.blocks.stony;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class RedSandstone extends BlockMaterialData
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__RED_SANDSTONE__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__RED_SANDSTONE__HARDNESS;

    public static final RedSandstone RED_SANDSTONE = new RedSandstone();

    private static final Map<String, RedSandstone>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<RedSandstone> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected RedSandstone()
    {
        super("RED_SANDSTONE", 179, "minecraft:red_sandstone", "RED_SANDSTONE", (byte) 0x00);
    }

    public RedSandstone(final String enumName, final int type)
    {
        super(RED_SANDSTONE.name(), RED_SANDSTONE.getId(), RED_SANDSTONE.getMinecraftId(), enumName, (byte) type);
    }

    public RedSandstone(final int maxStack, final String typeName, final byte type)
    {
        super(RED_SANDSTONE.name(), RED_SANDSTONE.getId(), RED_SANDSTONE.getMinecraftId(), maxStack, typeName, type);
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
    public RedSandstone getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public RedSandstone getType(final int id)
    {
        return getByID(id);
    }

    public static RedSandstone getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static RedSandstone getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final RedSandstone element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        RedSandstone.register(RED_SANDSTONE);
    }
}