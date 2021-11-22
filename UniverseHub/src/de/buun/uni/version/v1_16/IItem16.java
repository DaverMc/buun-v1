package de.buun.uni.version.v1_16;

import de.buun.uni.item.IItem;
import de.buun.uni.item.Item;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class IItem16 implements IItem<ItemStack> {
    @Override
    public ItemStack toMinecraftStack(Item item) {
        ItemStack stack = new ItemStack(Material.valueOf(item.getItemType().getName()));
        ItemMeta meta = stack.getItemMeta();
        meta.setLore(item.getLore());
        meta.setDisplayName(item.getName());
        return stack;
    }
}
