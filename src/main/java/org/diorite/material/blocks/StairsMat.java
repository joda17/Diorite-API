package org.diorite.material.blocks;

import org.diorite.BlockFace;

/**
 * Representing stairs block.
 */
public interface StairsMat extends DirectionalMat
{
    byte UPSIDE_DOWN_FLAG = 0x4;

    /**
     * @return true if stairs are upside-down
     */
    boolean isUpsideDown();

    /**
     * Returns sub-type of Stairs based on upside-down state.
     *
     * @param upsideDown if staris should be upside-down.
     *
     * @return sub-type of Stairs
     */
    StairsMat getUpsideDown(boolean upsideDown);

    /**
     * Returns one of Stairs sub-type based on facing direction and upside-down state.
     * It will never return null.
     *
     * @param face       facing direction of stairs.
     * @param upsideDown if stairs should be upside-down.
     *
     * @return sub-type of Stairs
     */
    StairsMat getType(BlockFace face, boolean upsideDown);

    static byte combine(final BlockFace face, final boolean upside)
    {
        byte value = upside ? UPSIDE_DOWN_FLAG : 0x0;
        switch (face)
        {
            case WEST:
                value += 0x1;
                break;
            case SOUTH:
                value += 0x2;
                break;
            case NORTH:
                value += 0x3;
                break;
            default:
                break;
        }
        return value;
    }
}
