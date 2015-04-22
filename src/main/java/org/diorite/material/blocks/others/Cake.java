package org.diorite.material.blocks.others;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.cfg.magic.MagicNumbers;
import org.diorite.material.BlockMaterialData;
import org.diorite.material.blocks.others.MushroomBlock.Type;
import org.diorite.utils.collections.SimpleStringHashMap;

import gnu.trove.map.TByteObjectMap;
import gnu.trove.map.hash.TByteObjectHashMap;

/**
 * Class representing block "Cake" and all its subtypes.
 */
public class Cake extends BlockMaterialData
{
    /**
     * Sub-ids used by diorite/minecraft by default
     */
    public static final byte  USED_DATA_VALUES = 6;
    /**
     * Blast resistance of block, can be changed only before server start.
     * Final copy of blast resistance from {@link MagicNumbers} class.
     */
    public static final float BLAST_RESISTANCE = MagicNumbers.MATERIAL__CAKE__BLAST_RESISTANCE;
    /**
     * Hardness of block, can be changed only before server start.
     * Final copy of hardness from {@link MagicNumbers} class.
     */
    public static final float HARDNESS         = MagicNumbers.MATERIAL__CAKE__HARDNESS;

    public static final Cake CAKE_0 = new Cake();
    public static final Cake CAKE_1 = new Cake(0x1);
    public static final Cake CAKE_2 = new Cake(0x2);
    public static final Cake CAKE_3 = new Cake(0x3);
    public static final Cake CAKE_4 = new Cake(0x4);
    public static final Cake CAKE_5 = new Cake(0x5);
    public static final Cake CAKE_6 = new Cake(0x6);

    private static final Map<String, Cake>    byName = new SimpleStringHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);
    private static final TByteObjectMap<Cake> byID   = new TByteObjectHashMap<>(USED_DATA_VALUES, SMALL_LOAD_FACTOR);

    protected final byte piecesEaten;

    @SuppressWarnings("MagicNumber")
    protected Cake()
    {
        super("CAKE", 92, "minecraft:cake", 1, "0", (byte) 0x00);
        this.piecesEaten = 0x0;
    }

    public Cake(final int piecesEaten)
    {
        super(CAKE_0.name(), CAKE_0.getId(), CAKE_0.getMinecraftId(), Integer.toString(piecesEaten), (byte) piecesEaten);
        this.piecesEaten = (byte) piecesEaten;
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
    public Cake getType(final String name)
    {
        return getByEnumName(name);
    }

    @Override
    public Cake getType(final int id)
    {
        return getByID(id);
    }

    /**
     * For vanilla cake blocks should return values from 0 to 6.
     *
     * @return amount of eated pieces of cake <3
     */
    public byte getPiecesEaten()
    {
        return this.piecesEaten;
    }

    /**
     * Return cake with selected amount of eaten pieces.
     * Vanilla server will return null for all values above 6.
     *
     * @param piecesEaten amount of eated pieces of cake.
     *
     * @return cake with selected amount of eaten pieces or null.
     */
    public Cake getPiecesEaten(final byte piecesEaten)
    {
        return getByID(piecesEaten);
    }

    /**
     * Returns one of Cake sub-type based on sub-id, may return null
     *
     * @param id sub-type id
     *
     * @return sub-type of Cake or null
     */
    public static Cake getByID(final int id)
    {
        return byID.get((byte) id);
    }

    /**
     * Returns one of Cake sub-type based on name (selected by diorite team), may return null
     * If block contains only one type, sub-name of it will be this same as name of material.
     *
     * @param name name of sub-type
     *
     * @return sub-type of Cake or null
     */
    public static Cake getByEnumName(final String name)
    {
        return byName.get(name);
    }

    /**
     * Returns one of Cake sub-type based on amount of eaten pieces.
     * It will never return null. (full cake if number is out of range)
     *
     * @param type amount of eaten pieces.
     *
     * @return sub-type of Cake
     */
    public static Cake getCake(final Type type)
    {
        final Cake cake = getByID(type.getFlag());
        if (cake == null)
        {
            return CAKE_0;
        }
        return cake;
    }

    /**
     * Register new sub-type, may replace existing sub-types.
     * Should be used only if you know what are you doing, it will not create fully usable material.
     *
     * @param element sub-type to register
     */
    public static void register(final Cake element)
    {
        byID.put(element.getType(), element);
        byName.put(element.name(), element);
    }

    static
    {
        Cake.register(CAKE_0);
        Cake.register(CAKE_1);
        Cake.register(CAKE_2);
        Cake.register(CAKE_3);
        Cake.register(CAKE_4);
        Cake.register(CAKE_5);
        Cake.register(CAKE_6);
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("piecesEaten", this.piecesEaten).toString();
    }
}
