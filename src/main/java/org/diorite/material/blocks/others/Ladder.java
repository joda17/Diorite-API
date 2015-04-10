package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Ladder extends BlockMaterialData
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__LADDER__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__LADDER__HARDNESS;

    public static final Ladder LADDER = new Ladder();

    private static final Map<String, Ladder>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<Ladder> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected Ladder()
    {
        super("LADDER", 65, "minecraft:ladder", "LADDER", (byte) 0x00);
    }

    public Ladder(final String enumName, final int type)
    {
        super(LADDER.name(), LADDER.getId(), LADDER.getMinecraftId(), enumName, (byte) type);
    }

    public Ladder(final int maxStack, final String typeName, final byte type)
    {
        super(LADDER.name(), LADDER.getId(), LADDER.getMinecraftId(), maxStack, typeName, type);
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
    public Ladder getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Ladder getType(final int id)
    {
        return getByID(id);
    }

    public static Ladder getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Ladder getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Ladder element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Ladder.register(LADDER);
    }
}