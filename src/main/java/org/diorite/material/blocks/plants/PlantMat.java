package org.diorite.material.blocks.plants;

import org.diorite.material.BlockMaterialData;

/**
 * Base abstract class for plant-based blocks
 */
public abstract class PlantMat extends BlockMaterialData
{
    protected PlantMat(final String enumName, final int id, final String minecraftId, final String typeName, final byte type)
    {
        super(enumName, id, minecraftId, typeName, type);
    }

    protected PlantMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type);
    }
}
