package org.diorite.inventory.item;

import org.diorite.material.Material;

public interface ItemStack
{
    Material getMaterial();

    int getAmount();

    short getDurability();

    ItemMeta getItemMeta();
}
