package org.diorite.material.blocks.wooden.wood.door;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.blocks.wooden.WoodType;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class BirchDoor extends WoodenDoor
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__BIRCH_DOOR__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__BIRCH_DOOR__HARDNESS;

    public static final BirchDoor BIRCH_DOOR = new BirchDoor();

    private static final Map<String, BirchDoor>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<BirchDoor> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected BirchDoor()
    {
        super("BIRCH_DOOR", 194, "minecraft:birch_door", "BIRCH_DOOR", WoodType.BIRCH);
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
    public BirchDoor getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public BirchDoor getType(final int id)
    {
        return getByID(id);
    }

    public static BirchDoor getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static BirchDoor getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final BirchDoor element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        BirchDoor.register(BIRCH_DOOR);
    }
}