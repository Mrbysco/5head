package com.mrbysco.fivehead.recipe;

import com.mrbysco.fivehead.FiveHead;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SmartRecipes {
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FiveHead.MOD_ID);
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, FiveHead.MOD_ID);

	public static final RegistryObject<SimpleCraftingRecipeSerializer<BigBrainRecipe>> BIG_BRAIN_SERIALIZER = RECIPE_SERIALIZERS.register("big_brain", () ->
			new SimpleCraftingRecipeSerializer<>(BigBrainRecipe::new));
}
