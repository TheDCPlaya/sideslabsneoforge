package com.thedcplaya.sideslabs;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(SideSlabs.MODID)
public class SideSlabs {
    public static final String MODID = "sideslabs";

    public SideSlabs(IEventBus modEventBus) {
        SideSlabBlocks.register(modEventBus);
        SideSlabItems.register(modEventBus);
        SideSlabCreativeTabs.register(modEventBus);
    }
}