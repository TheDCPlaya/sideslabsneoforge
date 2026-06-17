package com.thedcplaya.sideslabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SideSlabCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SideSlabs.MODID);

    static {
        TABS.register("main", () -> CreativeModeTab.builder()
                .icon(() -> SideSlabItems.ALL_ITEMS.get(0).get().getDefaultInstance())
                .title(Component.literal("Side Slabs"))
                .displayItems((params, output) -> SideSlabItems.ALL_ITEMS.forEach(item -> output.accept(item.get())))
                .build());
    }

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
