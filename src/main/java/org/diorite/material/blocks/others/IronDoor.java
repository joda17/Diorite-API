package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.Door;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class IronDoor extends BlockMaterialData implements Door
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__IRON_DOOR__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__IRON_DOOR__HARDNESS;

    public static final IronDoor IRON_DOOR = new IronDoor();

    private static final Map<String, IronDoor>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<IronDoor> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected IronDoor()
    {
        super("IRON_DOOR", 71, "minecraft:iron_door", "IRON_DOOR", (byte) 0x00);
    }

    public IronDoor(final String enumName, final int type)
    {
        super(IRON_DOOR.name(), IRON_DOOR.getId(), IRON_DOOR.getMinecraftId(), enumName, (byte) type);
    }

    public IronDoor(final int maxStack, final String typeName, final byte type)
    {
        super(IRON_DOOR.name(), IRON_DOOR.getId(), IRON_DOOR.getMinecraftId(), maxStack, typeName, type);
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
    public IronDoor getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public IronDoor getType(final int id)
    {
        return getByID(id);
    }

    public static IronDoor getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static IronDoor getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final IronDoor element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        IronDoor.register(IRON_DOOR);
    }
}