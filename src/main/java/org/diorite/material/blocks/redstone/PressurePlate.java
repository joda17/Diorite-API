package org.diorite.material.blocks.redstone;

import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.Activatable;

public abstract class PressurePlate extends BlockMaterialData implements Activatable
{
    public PressurePlate(final String enumName, final int id, final String minecraftId, final String typeName, final byte type)
    {
        super(enumName, id, minecraftId, typeName, type);
    }

    public PressurePlate(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type);
    }

    @Override
    public PressurePlate getActivated(final boolean activate)
    {
        return null; // TODO: implement
    }

    public static PressurePlate getType(final boolean activate)
    {
        return null; // TODO: implement
    }
}