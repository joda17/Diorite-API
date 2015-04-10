package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class Torch extends BlockMaterialData
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__TORCH__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__TORCH__HARDNESS;

    public static final Torch TORCH = new Torch();

    private static final Map<String, Torch>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<Torch> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected Torch()
    {
        super("TORCH", 50, "minecraft:torch", "TORCH", (byte) 0x00);
    }

    public Torch(final String enumName, final int type)
    {
        super(TORCH.name(), TORCH.getId(), TORCH.getMinecraftId(), enumName, (byte) type);
    }

    public Torch(final int maxStack, final String typeName, final byte type)
    {
        super(TORCH.name(), TORCH.getId(), TORCH.getMinecraftId(), maxStack, typeName, type);
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
    public Torch getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Torch getType(final int id)
    {
        return getByID(id);
    }

    public static Torch getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static Torch getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final Torch element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Torch.register(TORCH);
    }
}