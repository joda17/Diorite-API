package org.diorite.cfg.system.elements;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.cfg.system.CfgEntryData;

public class SimpleTemplateElement<T> extends TemplateElement<T>
{
    public SimpleTemplateElement(final Class<T> fieldType, final Function<Object, T> function, final Predicate<Class<?>> classPredicate)
    {
        super(fieldType, function, classPredicate);
    }

    public SimpleTemplateElement(final Class<T> clazz, final Function<Object, T> function)
    {
        super(clazz, function);
    }

    @Override
    protected void appendValue(final Appendable writer, final CfgEntryData field, final Object source, final Object object, final int level, final ElementPlace elementPlace) throws IOException
    {
        writer.append(object.toString());
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("function", this.function).toString();
    }
}