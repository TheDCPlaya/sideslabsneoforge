package com.thedcplaya.sideslabs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class SideSlabItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SideSlabs.MODID);
    public static final List<DeferredItem<BlockItem>> ALL_ITEMS = new ArrayList<>();

    static {
        SideSlabBlocks.ALL_BLOCKS.forEach(blockReg -> {
            DeferredItem<BlockItem> item = ITEMS.registerItem(
                    blockReg.getId().getPath(),
                    props -> new BlockItem(blockReg.get(), props),
                    new Item.Properties()
            );
            ALL_ITEMS.add(item);
        });
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
