package org.diorite.material.blocks.plants;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Cactus extends Plant
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__CACTUS__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__CACTUS__HARDNESS;

    public static final Cactus CACTUS = new Cactus();

    private static final Map<String, Cactus>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<Cactus> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected Cactus()
    {
        super("CACTUS", 81, "minecraft:cactus", "CACTUS", (byte) 0x00);
    }

    public Cactus(final String enumName, final int type)
    {
        super(CACTUS.name(), CACTUS.getId(), CACTUS.getMinecraftId(), enumName, (byte) type);
    }

    public Cactus(final int maxStack, final String typeName, final byte type)
    {
        super(CACTUS.name(), CACTUS.getId(), CACTUS.getMinecraftId(), maxStack, typeName, type);
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
    public Cactus getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Cactus getType(final int id)
    {
        return getByID(id);
    }

    public static Cactus getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Cactus getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Cactus element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Cactus.register(CACTUS);
    }
}