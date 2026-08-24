package com.natsu.elixirs.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;

// there's no brewing API in this Fabric version, so we invoke the vanilla private addMix directly.
// an @Invoker gets the target name remapped through the refmap, unlike reflection by mojmap name.
@Mixin(PotionBrewing.class)
public interface PotionBrewingInvoker {

	@Invoker("addMix")
	static void elixirs$addMix(Potion input, Item ingredient, Potion output) {
		throw new AssertionError();
	}
}
