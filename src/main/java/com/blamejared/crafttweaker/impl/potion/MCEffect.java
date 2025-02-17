package com.blamejared.crafttweaker.impl.potion;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.brackets.CommandStringDisplayable;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.impl.helper.CraftTweakerHelper;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import org.openzen.zencode.java.ZenCodeType;

import java.util.List;

@ZenRegister
@ZenCodeType.Name("crafttweaker.api.potion.MCPotionEffect")
public class MCEffect implements CommandStringDisplayable {
    
    private final Effect internal;
    
    public MCEffect(Effect internal) {
        this.internal = internal;
    }
    
    @ZenCodeType.Method
    public MCEffectInstance newInstance(int duration, @ZenCodeType.OptionalInt int amplifier) {
        return new MCEffectInstance(new EffectInstance(getInternal(), duration, amplifier));
    }
    
    @ZenCodeType.Method
    public boolean isReady(int duration, int amplifier) {
        return internal.isReady(duration, amplifier);
    }
    
    @ZenCodeType.Getter("isInstant")
    public boolean isInstant() {
        return internal.isInstant();
    }
    
    @ZenCodeType.Getter("name")
    public String getName() {
        return internal.getName();
    }
    
    @ZenCodeType.Getter("displayName")
    public String getDisplayName() {
        return internal.getDisplayName().getFormattedText();
    }
    
    @ZenCodeType.Getter("liquidColor")
    public int getLiquidColor() {
        return internal.getLiquidColor();
    }
    
    @ZenCodeType.Getter("isBeneficial")
    public boolean isBeneficial() {
        return internal.isBeneficial();
    }
    
    @ZenCodeType.Getter("curativeItems")
    public List<IItemStack> getCurativeItems() {
        return CraftTweakerHelper.getIItemStacks(internal.getCurativeItems());
    }
    
    public Effect getInternal() {
        return internal;
    }

    @Override
    public String getCommandString() {
        return "<effect:" + internal.getRegistryName() + ">";
    }
}
