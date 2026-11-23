package atonkish.reinfcore.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import atonkish.reinfcore.mixin.ItemGroupAccessor;

public class ModItemGroup {
  public static void setIcon(CreativeModeTab itemGroup, ItemLike item) {
    ItemStack itemStack = new ItemStack(item);
    ((ItemGroupAccessor) itemGroup).setIcon(itemStack);
  }
}
