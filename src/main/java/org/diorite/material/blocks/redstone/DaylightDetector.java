package org.diorite.material.blocks.redstone;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.Activatable;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class DaylightDetector extends BlockMaterialData implements Activatable
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__DAYLIGHT_DETECTOR__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__DAYLIGHT_DETECTOR__HARDNESS;

    public static final DaylightDetector DAYLIGHT_DETECTOR = new DaylightDetector();

    private static final Map<String, DaylightDetector>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<DaylightDetector> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected DaylightDetector()
    {
        super("DAYLIGHT_DETECTOR", 151, "minecraft:daylight_detector", "DAYLIGHT_DETECTOR", (byte) 0x00);
    }

    public DaylightDetector(final String enumName, final int type)
    {
        super(DAYLIGHT_DETECTOR.name(), DAYLIGHT_DETECTOR.getId(), DAYLIGHT_DETECTOR.getMinecraftId(), enumName, (byte) type);
    }

    public DaylightDetector(final int maxStack, final String typeName, final byte type)
    {
        super(DAYLIGHT_DETECTOR.name(), DAYLIGHT_DETECTOR.getId(), DAYLIGHT_DETECTOR.getMinecraftId(), maxStack, typeName, type);
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
    public DaylightDetector getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public DaylightDetector getType(final int id)
    {
        return getByID(id);
    }

    @Override
    public boolean isActivated()
    {
        return false; // TODO: implement
    }

    @Override
    public BlockMaterialData getActivated(final boolean activate)
    {
        return null;  // TODO: implement
    }

    public static DaylightDetector getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static DaylightDetector getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final DaylightDetector element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        DaylightDetector.register(DAYLIGHT_DETECTOR);
    }
}