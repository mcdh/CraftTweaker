package com.blamejared.crafttweaker.impl.food;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.impl.potion.MCEffectInstance;
import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import org.apache.commons.lang3.tuple.Pair;
import org.openzen.zencode.java.ZenCodeType;

@ZenCodeType.Name("crafttweaker.api.food.MCFood")
@ZenRegister
public class MCFood {
    
    private final Food internal;
    
    public MCFood(Food internal) {
        this.internal = internal;
    }
    
    @ZenCodeType.Constructor
    public MCFood(int healing, float saturation) {
        this(new Food.Builder().hunger(healing).saturation(saturation).build());
    }
    
    @ZenCodeType.Getter("healing")
    public int getHealing() {
        return getInternal().getHealing();
    }
    
    @ZenCodeType.Method
    public MCFood setHealing(int healing) {
        Food food = copyInternal();
        food.value = healing;
        return new MCFood(food);
    }
    
    @ZenCodeType.Getter("saturation")
    public float getSaturation() {
        return getInternal().getSaturation();
    }
    
    @ZenCodeType.Method
    public MCFood setSaturation(float saturation) {
        Food food = copyInternal();
        food.saturation = saturation;
        return new MCFood(food);
    }
    
    @ZenCodeType.Getter("meat")
    public boolean isMeat() {
        return getInternal().isMeat();
    }
    
    @ZenCodeType.Method
    public MCFood setMeat(boolean meat) {
        Food food = copyInternal();
        food.meat = meat;
        return new MCFood(food);
    }
    
    @ZenCodeType.Getter("canEatWhenFull")
    public boolean canEatWhenFull() {
        return getInternal().canEatWhenFull();
    }
    
    @ZenCodeType.Method
    public MCFood setCanEatWhenFull(boolean canEatWhenFull) {
        Food food = copyInternal();
        food.canEatWhenFull = canEatWhenFull;
        return new MCFood(food);
    }
    
    @ZenCodeType.Getter("isFastEating")
    public boolean isFastEating() {
        return getInternal().isFastEating();
    }
    
    @ZenCodeType.Method
    public MCFood setFastEating(boolean fastEating) {
        Food food = copyInternal();
        food.fastToEat = fastEating;
        return new MCFood(food);
    }
    
    @ZenCodeType.Method
    public void clearEffects() {
        getInternal().effects.clear();
    }
    
    @ZenCodeType.Method
    public MCFood addEffect(MCEffectInstance effect, float probability) {
        Food food = copyInternal();
        food.effects.add(Pair.of(effect.getInternal(), probability));
        return new MCFood(food);
    }
    
    @ZenCodeType.Method
    public MCFood removeEffect(MCEffectInstance effect) {
        Food food = copyInternal();
        food.effects.removeIf(pair -> pair.getLeft().equals(effect.getInternal()));
        return new MCFood(food);
    }
    
    public Food getInternal() {
        return internal;
    }
    
    private Food copyInternal() {
        Food.Builder builder = new Food.Builder();
        if(this.isMeat()) {
            builder.meat();
        }
        if(this.isFastEating()) {
            builder.fastToEat();
        }
        builder.saturation(getSaturation());
        builder.hunger(getHealing());
        for(Pair<EffectInstance, Float> effect : getInternal().getEffects()) {
            builder.effect(effect.getKey(), effect.getRight());
        }
        return builder.build();
    }
    
    // TODO When we have a Pair implementation in ZS/CRT, uncomment this
    //    @ZenCodeType.Getter("effects")
    //    public List<Pair<MCEffectInstance, Float>> getEffects() {
    //        return internal.getEffects().stream().map(pair -> Pair.of(new MCEffectInstance(pair.getLeft()), pair.getRight())).collect(Collectors.toList());
    //    }
}
