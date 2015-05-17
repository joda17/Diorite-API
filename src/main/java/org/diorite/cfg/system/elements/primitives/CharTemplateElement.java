package org.diorite.cfg.system.elements.primitives;

/**
 * Template used by chars.
 */
public class CharTemplateElement extends SimpleTemplateElement<Character>
{
    /**
     * Instance of template to direct-use.
     */
    public static final CharTemplateElement INSTANCE = new CharTemplateElement();

    /**
     * Construct new char template
     */
    public CharTemplateElement()
    {
        super(char.class);
    }

    @Override
    protected Character convertDefault(final Object def)
    {
        throw new UnsupportedOperationException("Can't convert default value (" + def.getClass().getName() + "): " + def);
    }
}
