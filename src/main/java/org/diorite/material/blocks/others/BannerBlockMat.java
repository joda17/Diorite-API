package org.diorite.material.blocks.others;

import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.DirectionalMat;

/**
 * Base abstract class for all banner-based blocks
 */
public abstract class BannerBlockMat extends BlockMaterialData implements DirectionalMat
{
    protected BannerBlockMat(final String enumName, final int id, final String minecraftId, final String typeName, final byte type)
    {
        super(enumName, id, minecraftId, typeName, type);
    }

    protected BannerBlockMat(final String enumName, final int id, final String minecraftId, final int maxStack, final String typeName, final byte type)
    {
        super(enumName, id, minecraftId, maxStack, typeName, type);
    }
}
