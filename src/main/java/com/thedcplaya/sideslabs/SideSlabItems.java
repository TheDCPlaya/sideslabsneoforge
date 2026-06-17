package com.thedcplaya.sideslabs;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.Supplier;

import static net.minecraft.world.item.CreativeModeTab.*;

public class SideSlabItems {
    // Replace this with your actual registration helper instance
    // Example: public static final DeferredRegisterHelper<Item> ITEMS = ModItems.ITEMS;
    // For the repo's helper name use the existing ITEMS field you already have.
    public static final ItemsHelper ITEMS = ItemsHelper.INSTANCE; // <-- adjust to your helper

    // Register a BlockItem for the side slab
    public static final DeferredItem<BlockItem> SIDE_SLAB_ITEM = ITEMS.registerItem(
            "side_slab",
            props -> new BlockItem(SideSlabBlocks.SIDE_SLAB.get(), props),
            (Supplier<Item.Properties>) () -> new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)
    );

    // Call this from your mod init to ensure registration happens (if needed)
    public static void register() {
        // no-op if your registration system auto-registers static fields
    }
}
