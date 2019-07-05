package com.blamejared.crafttweaker.impl.managers;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.managers.ISingleRecipeManager;
import net.minecraft.item.crafting.IRecipeType;
import org.openzen.zencode.java.ZenCodeGlobals;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("crafttweaker.api.FurnaceManager")
public class CTFurnaceManager implements ISingleRecipeManager {
    
    @ZenCodeGlobals.Global("furnace")
    public static final CTFurnaceManager INSTANCE = new CTFurnaceManager();
    
    @Override
    public void addRecipe(String name, IItemStack output, IIngredient input, float xp, int cookTime, @ZenCodeType.Optional RecipeFunctionSingle function) {
//        CraftTweakerAPI.apply(new ActionAddRecipe(getRecipeType(), new CTFurnaceRecipe(new ResourceLocation(CraftTweaker.MODID, name), input.asVanillaIngredient(), output.getInternal(), xp, cookTime, function), ""));
    }
    
    @Override
    public void removeRecipe(IItemStack output, IIngredient input) {
    
    }
    
    @Override
    public void removeByName(String name) {
    
    }
    
    @Override
    public void remove(IItemStack output) {
    
    }
    
    @Override
    public IRecipeType getRecipeType() {
        return IRecipeType.SMELTING;
    }
    
}
