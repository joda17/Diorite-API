package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class MobSpawner extends BlockMaterialData
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__MOB_SPAWNER__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__MOB_SPAWNER__HARDNESS;

    public static final MobSpawner MOB_SPAWNER = new MobSpawner();

    private static final Map<String, MobSpawner>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<MobSpawner> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected MobSpawner()
    {
        super("MOB_SPAWNER", 52, "minecraft:mob_spawner", "MOB_SPAWNER", (byte) 0x00);
    }

    public MobSpawner(final String enumName, final int type)
    {
        super(MOB_SPAWNER.name(), MOB_SPAWNER.getId(), MOB_SPAWNER.getMinecraftId(), enumName, (byte) type);
    }

    public MobSpawner(final int maxStack, final String typeName, final byte type)
    {
        super(MOB_SPAWNER.name(), MOB_SPAWNER.getId(), MOB_SPAWNER.getMinecraftId(), maxStack, typeName, type);
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
    public MobSpawner getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public MobSpawner getType(final int id)
    {
        return getByID(id);
    }

    public static MobSpawner getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static MobSpawner getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final MobSpawner element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        MobSpawner.register(MOB_SPAWNER);
    }
}