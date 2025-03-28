package com.mrbysco.fivehead.recipe;

import com.mrbysco.fivehead.FiveHead;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class SmartRecipes {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, FiveHead.MOD_ID);

	public static final Supplier<RecipeSerializer<BigBrainRecipe>> BIG_BRAIN_SERIALIZER = RECIPE_SERIALIZERS.register("big_brain", () ->
			new CustomRecipe.Serializer<>(BigBrainRecipe::new));
}
