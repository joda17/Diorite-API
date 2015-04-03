package org.diorite.material.blocks.ore;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class LapisOre extends Ore
{
    public static final byte USED_DATA_VALUES = 1;

    public static final LapisOre LAPIS_ORE = new LapisOre();

    private static final Map<String, LapisOre>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SLOW_GROW);
    private static final TByteObjectMap<LapisOre> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SLOW_GROW);

    @SuppressWarnings("MagicNumber")
    protected LapisOre()
    {
        super("LAPIS_ORE", 21, "minecraft:lapis_ore", "LAPIS_ORE", (byte) 0x00);
    }

    public LapisOre(final String enumName, final int type)
    {
        super(LAPIS_ORE.name(), LAPIS_ORE.getId(), LAPIS_ORE.getMinecraftId(), enumName, (byte) type);
    }

    public LapisOre(final int maxStack, final String typeName, final byte type)
    {
        super(LAPIS_ORE.name(), LAPIS_ORE.getId(), LAPIS_ORE.getMinecraftId(), maxStack, typeName, type);
    }

    @Override
    public float getBlastResistance()
    {
        return MagicNumbers.MATERIAL__LAPIS_ORE__BLAST_RESISTANCE;
    }

    @Override
    public float getHardness()
    {
        return MagicNumbers.MATERIAL__LAPIS_ORE__HARDNESS;
    }

    @Override
    public LapisOre getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public LapisOre getType(final int id)
    {
        return getByID(id);
    }

    public static LapisOre getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static LapisOre getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final LapisOre element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        LapisOre.register(LAPIS_ORE);
    }
}
