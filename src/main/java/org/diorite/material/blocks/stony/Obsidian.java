package org.diorite.material.blocks.stony;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Obsidian extends BlockMaterialData
{
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__OBSIDIAN__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__OBSIDIAN__HARDNESS;

    public static final Obsidian OBSIDIAN = new Obsidian();

    private static final Map<String, Obsidian>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<Obsidian> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected Obsidian()
    {
        super("OBSIDIAN", 49, "minecraft:obsidian", "OBSIDIAN", (byte) 0x00);
    }

    public Obsidian(final String enumName, final int type)
    {
        super(OBSIDIAN.name(), OBSIDIAN.getId(), OBSIDIAN.getMinecraftId(), enumName, (byte) type);
    }

    public Obsidian(final int maxStack, final String typeName, final byte type)
    {
        super(OBSIDIAN.name(), OBSIDIAN.getId(), OBSIDIAN.getMinecraftId(), maxStack, typeName, type);
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
    public Obsidian getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Obsidian getType(final int id)
    {
        return getByID(id);
    }

    public static Obsidian getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Obsidian getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Obsidian element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Obsidian.register(OBSIDIAN);
    }
}