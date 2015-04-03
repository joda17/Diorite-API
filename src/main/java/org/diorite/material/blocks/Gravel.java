package org.diorite.material.blocks;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Gravel extends BlockMaterialData
{
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__GRAVEL__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__GRAVEL__HARDNESS;

    public static final Gravel GRAVEL = new Gravel();

    private static final Map<String, Gravel>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SLOW_GROW);
    private static final TByteObjectMap<Gravel> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SLOW_GROW);

    @SuppressWarnings("MagicNumber")
    protected Gravel()
    {
        super("GRAVEL", 13, "minecraft:gravel", "GRAVEL", (byte) 0x00);
    }

    public Gravel(final String enumName, final int type)
    {
        super(GRAVEL.name(), GRAVEL.getId(), GRAVEL.getMinecraftId(), enumName, (byte) type);
    }

    public Gravel(final int maxStack, final String typeName, final byte type)
    {
        super(GRAVEL.name(), GRAVEL.getId(), GRAVEL.getMinecraftId(), maxStack, typeName, type);
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
    public Gravel getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Gravel getType(final int id)
    {
        return getByID(id);
    }

    public static Gravel getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Gravel getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Gravel element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Gravel.register(GRAVEL);
    }
}