package atonkish.reinfcore.mixin;

import java.util.function.Supplier;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreativeModeTab.class)
public interface ItemGroupAccessor {
  // Since 26.x, an ItemStack cannot be created while mods initialize: the tab gets a supplier,
  // which the game calls the first time it needs the icon
  @Mutable
  @Accessor("iconGenerator")
  public void setIconGenerator(Supplier<ItemStack> iconGenerator);
}
