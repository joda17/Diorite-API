package org.diorite.material.blocks.others;

import java.util.Map;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.blocks.stony.Stony;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

public class MonsterEggTrap extends Stony
{
    // TODO: auto-generated class, implement other types (sub-ids).
    public static final byte  USED_DATA_VALUES = 1;
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__MONSTER_EGG_TRAP__BLAST_RESISTANCE;
    public static final float HARDNESS         = MagicNumbers.MATERIAL__MONSTER_EGG_TRAP__HARDNESS;

    public static final MonsterEggTrap MONSTER_EGG_TRAP = new MonsterEggTrap();

    private static final Map<String, MonsterEggTrap>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<MonsterEggTrap> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    @SuppressWarnings("MagicNumber")
    protected MonsterEggTrap()
    {
        super("MONSTER_EGG_TRAP", 97, "minecraft:monster_egg", "MONSTER_EGG_TRAP", (byte) 0x00);
    }

    public MonsterEggTrap(final String enumName, final int type)
    {
        super(MONSTER_EGG_TRAP.name(), MONSTER_EGG_TRAP.getId(), MONSTER_EGG_TRAP.getMinecraftId(), enumName, (byte) type);
    }

    public MonsterEggTrap(final int maxStack, final String typeName, final byte type)
    {
        super(MONSTER_EGG_TRAP.name(), MONSTER_EGG_TRAP.getId(), MONSTER_EGG_TRAP.getMinecraftId(), maxStack, typeName, type);
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
    public MonsterEggTrap getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public MonsterEggTrap getType(final int id)
    {
        return getByID(id);
    }

    public static MonsterEggTrap getByID(final int id)
    {
        return byID.get((byte) id);
    }

    public static MonsterEggTrap getByEnumName(final String name)
    {
        return byName.get(name);
    }

    public static void register(final MonsterEggTrap element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        MonsterEggTrap.register(MONSTER_EGG_TRAP);
    }
}