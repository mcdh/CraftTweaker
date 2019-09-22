package com.blamejared.crafttweaker.api.zencode.expands;

import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.data.IData;
import com.blamejared.crafttweaker.impl.data.ByteData;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Expansion("byte?")
public class ExpandByte {
    
    @ZenCodeType.Caster(implicit = true)
    public static IData asData(Byte value) {
        return new ByteData(value);
    }
    
}
