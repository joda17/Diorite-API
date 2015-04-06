package org.diorite.material.blocks.stony.oreblocks;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.Material;
import org.diorite.material.blocks.stony.ore.Ore;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class EmeraldBlock extends OreBlock
{
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__EMERALD_BLOCK__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__EMERALD_BLOCK__HARDNESS;

    public static final EmeraldBlock EMERALD_BLOCK = new EmeraldBlock(Material.EMERALD_ORE);

    private static final Map<String, EmeraldBlock>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<EmeraldBlock> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected EmeraldBlock(final Ore ore)
    {
        super("EMERALD_BLOCK", 133, "minecraft:emerald_block", "EMERALD_BLOCK", (byte) 0x00, ore);
    }

    public EmeraldBlock(final String enumName, final int type, final Ore ore)
    {
        super(EMERALD_BLOCK.name(), EMERALD_BLOCK.getId(), EMERALD_BLOCK.getMinecraftId(), enumName, (byte) type, ore);
    }

    public EmeraldBlock(final int maxStack, final String typeName, final byte type, final Ore ore)
    {
        super(EMERALD_BLOCK.name(), EMERALD_BLOCK.getId(), EMERALD_BLOCK.getMinecraftId(), maxStack, typeName, type, ore);
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
    public EmeraldBlock getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public EmeraldBlock getType(final int id)
    {
        return getByID(id);
    }

    public static EmeraldBlock getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static EmeraldBlock getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final EmeraldBlock element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        EmeraldBlock.register(EMERALD_BLOCK);
    }
}