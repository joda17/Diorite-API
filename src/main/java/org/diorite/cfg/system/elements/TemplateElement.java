package org.diorite.cfg.system.elements;

import java.io.IOException;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.cfg.system.CfgEntryData;
import org.diorite.cfg.system.ConfigField;
import org.diorite.cfg.system.FieldOptions;
import org.diorite.cfg.system.Template;
import org.diorite.utils.reflections.DioriteReflectionUtils;
import org.diorite.utils.reflections.ReflectGetter;

public abstract class TemplateElement<T>
{
    protected final Class<T>            fieldType;
    protected final Function<Object, T> function;
    protected final Predicate<Class<?>> classPredicate;

    protected TemplateElement(final Class<T> fieldType, final Function<Object, T> function)
    {
        this.fieldType = fieldType;
        this.function = function;
        this.classPredicate = null;
    }


    protected TemplateElement(final Class<T> fieldType, final Function<Object, T> function, final Predicate<Class<?>> classPredicate)
    {
        this.fieldType = fieldType;
        this.function = function;
        this.classPredicate = classPredicate;
    }

    public Class<T> getFieldType()
    {
        return this.fieldType;
    }

    public boolean isValidType(final Class<?> clazz)
    {
        return DioriteReflectionUtils.getPrimitive(this.fieldType).isAssignableFrom(clazz) || DioriteReflectionUtils.getWrapperClass(this.fieldType).isAssignableFrom(clazz);
    }

    public boolean canBeConverted(final Class<?> clazz)
    {
        return this.isValidType(clazz) || ((this.classPredicate != null) && this.classPredicate.test(clazz));
    }

    public void write(final Appendable writer, final ConfigField field, final Object object, final ReflectGetter<?> invoker, final int level, final boolean addComments, final ElementPlace elementPlace) throws IOException
    {
        Object element = invoker.get(object);
        if (element == null)
        {
            element = field.getDefault();
        }
        if (element != null)
        {
            writer.append('\n');
            if (addComments && (field.getHeader() != null))
            {
                Template.appendComment(writer, field.getHeader(), level, false);
                writer.append('\n');
            }

            appendElement(writer, level, field.getName());
            writer.append(": ");
            this.appendValue(writer, field, object, this.validateType(element), level, elementPlace);

            if (addComments && (field.getFooter() != null))
            {
                if (field.getOption(FieldOptions.OTHERS_FOOTER_NO_NEW_LINE, false))
                {
                    Template.appendComment(writer, field.getFooter(), level, true);
                }
                else
                {
                    writer.append('\n');
                    Template.appendComment(writer, field.getFooter(), level, false);
                    writer.append('\n');
                }
            }
        }
    }

    public void writeValue(final Appendable writer, final CfgEntryData field, final Object object, final Object element, final int level, final boolean addComments, final ElementPlace elementPlace) throws IOException
    {
        if (element != null)
        {
            if (addComments && (field.getHeader() != null))
            {
                appendElement(writer, level, field.getHeader());
                writer.append('\n');
            }

            this.appendValue(writer, field, object, this.validateType(element), level, elementPlace);

//            if (elementPlace == ElementPlace.NORMAL)
//            {
//               writer.append('\n');
//            }
            if (addComments && (field.getFooter() != null))
            {
                appendElement(writer, level, field.getFooter());
                writer.append('\n');
            }
        }
    }

    protected abstract void appendValue(final Appendable writer, final CfgEntryData field, final Object source, final Object element, final int level, final ElementPlace elementPlace) throws IOException;

    protected T validateType(final Object obj)
    {
        if (this.fieldType.isAssignableFrom(obj.getClass()))
        {
            //noinspection unchecked
            return (T) obj;
        }
        return this.function.apply(obj);
    }

    protected static void appendElement(final Appendable writer, final int level, final CharSequence element) throws IOException
    {
        spaces(writer, level);
        writer.append(element);
    }

    protected static void spaces(final Appendable writer, final int level) throws IOException
    {
        if (level <= 0)
        {
            return;
        }
        for (int i = 0; i < level; i++)
        {
            writer.append("  ");
        }
    }

    public enum ElementPlace
    {
        NORMAL,
        LIST,
        SIMPLE_LIST_OR_MAP,;
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("fieldType", this.fieldType).toString();
    }
}