package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class StandingSign extends SignBlock
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__STANDING_SIGN__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__STANDING_SIGN__HARDNESS;

    public static final StandingSign STANDING_SIGN = new StandingSign();

    private static final Map<String, StandingSign>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<StandingSign> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected StandingSign()
    {
        super("STANDING_SIGN", 63, "minecraft:standing_sign", "STANDING_SIGN", (byte) 0x00);
    }

    public StandingSign(final String enumName, final int type)
    {
        super(STANDING_SIGN.name(), STANDING_SIGN.getId(), STANDING_SIGN.getMinecraftId(), enumName, (byte) type);
    }

    public StandingSign(final int maxStack, final String typeName, final byte type)
    {
        super(STANDING_SIGN.name(), STANDING_SIGN.getId(), STANDING_SIGN.getMinecraftId(), maxStack, typeName, type);
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
    public StandingSign getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public StandingSign getType(final int id)
    {
        return getByID(id);
    }

    public static StandingSign getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static StandingSign getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final StandingSign element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        StandingSign.register(STANDING_SIGN);
    }
}