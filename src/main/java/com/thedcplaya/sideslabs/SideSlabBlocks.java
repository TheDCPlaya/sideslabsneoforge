package com.thedcplaya.sideslabs;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class SideSlabBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SideSlabs.MODID);
    public static final List<DeferredBlock<Block>> ALL_BLOCKS = new ArrayList<>();

    static {
        register("oak", Blocks.OAK_SLAB);
        register("spruce", Blocks.SPRUCE_SLAB);
        register("birch", Blocks.BIRCH_SLAB);
        register("jungle", Blocks.JUNGLE_SLAB);
        register("acacia", Blocks.ACACIA_SLAB);
        register("dark_oak", Blocks.DARK_OAK_SLAB);
        register("mangrove", Blocks.MANGROVE_SLAB);
        register("cherry", Blocks.CHERRY_SLAB);
        register("bamboo", Blocks.BAMBOO_SLAB);
        register("stone", Blocks.STONE_SLAB);
        register("cobblestone", Blocks.COBBLESTONE_SLAB);
        register("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE_SLAB);
        register("stone_brick", Blocks.STONE_BRICK_SLAB);
        register("mossy_stone_brick", Blocks.MOSSY_STONE_BRICK_SLAB);
        register("granite", Blocks.GRANITE_SLAB);
        register("polished_granite", Blocks.POLISHED_GRANITE_SLAB);
        register("diorite", Blocks.DIORITE_SLAB);
        register("polished_diorite", Blocks.POLISHED_DIORITE_SLAB);
        register("andesite", Blocks.ANDESITE_SLAB);
        register("polished_andesite", Blocks.POLISHED_ANDESITE_SLAB);
        register("sandstone", Blocks.SANDSTONE_SLAB);
        register("cut_sandstone", Blocks.CUT_SANDSTONE_SLAB);
        register("smooth_sandstone", Blocks.SMOOTH_SANDSTONE_SLAB);
        register("red_sandstone", Blocks.RED_SANDSTONE_SLAB);
        register("cut_red_sandstone", Blocks.CUT_RED_SANDSTONE_SLAB);
        register("smooth_red_sandstone", Blocks.SMOOTH_RED_SANDSTONE_SLAB);
        register("brick", Blocks.BRICK_SLAB);
        register("prismarine", Blocks.PRISMARINE_SLAB);
        register("prismarine_brick", Blocks.PRISMARINE_BRICK_SLAB);
        register("dark_prismarine", Blocks.DARK_PRISMARINE_SLAB);
        register("nether_brick", Blocks.NETHER_BRICK_SLAB);
        register("red_nether_brick", Blocks.RED_NETHER_BRICK_SLAB);
        register("quartz", Blocks.QUARTZ_SLAB);
        register("smooth_quartz", Blocks.SMOOTH_QUARTZ_SLAB);
        register("purpur", Blocks.PURPUR_SLAB);
        register("blackstone", Blocks.BLACKSTONE_SLAB);
        register("polished_blackstone", Blocks.POLISHED_BLACKSTONE_SLAB);
        register("polished_blackstone_brick", Blocks.POLISHED_BLACKSTONE_BRICK_SLAB);
        register("deepslate", Blocks.DEEPSLATE_SLAB);
        register("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE_SLAB);
        register("polished_deepslate", Blocks.POLISHED_DEEPSLATE_SLAB);
        register("deepslate_brick", Blocks.DEEPSLATE_BRICK_SLAB);
        register("deepslate_tile", Blocks.DEEPSLATE_TILE_SLAB);
        register("tuff", Blocks.TUFF_SLAB);
        register("polished_tuff", Blocks.POLISHED_TUFF_SLAB);
        register("tuff_brick", Blocks.TUFF_BRICK_SLAB);
        register("mud_brick", Blocks.MUD_BRICK_SLAB);
    }

    private static void register(String name, Block base) {
        DeferredBlock<Block> block = BLOCKS.registerBlock(
                name + "_side_slab",
                props -> new SideSlabBlock(props),
                BlockBehaviour.Properties.ofFullCopy(base));
        ALL_BLOCKS.add(block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
