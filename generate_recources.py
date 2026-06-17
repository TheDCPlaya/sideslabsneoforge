import os
import json

# All side slabs (name -> texture folder)
slabs = {
    "oak": "oak_planks",
    "spruce": "spruce_planks",
    "birch": "birch_planks",
    "jungle": "jungle_planks",
    "acacia": "acacia_planks",
    "dark_oak": "dark_oak_planks",
    "mangrove": "mangrove_planks",
    "cherry": "cherry_planks",
    "bamboo": "bamboo_planks",
    "stone": "stone",
    "cobblestone": "cobblestone",
    "mossy_cobblestone": "mossy_cobblestone",
    "stone_brick": "stone_bricks",
    "mossy_stone_brick": "mossy_stone_bricks",
    "granite": "granite",
    "polished_granite": "polished_granite",
    "diorite": "diorite",
    "polished_diorite": "polished_diorite",
    "andesite": "andesite",
    "polished_andesite": "polished_andesite",
    "sandstone": "sandstone",
    "cut_sandstone": "cut_sandstone",
    "smooth_sandstone": "smooth_sandstone",
    "red_sandstone": "red_sandstone",
    "cut_red_sandstone": "cut_red_sandstone",
    "smooth_red_sandstone": "smooth_red_sandstone",
    "brick": "bricks",
    "prismarine": "prismarine",
    "prismarine_brick": "prismarine_bricks",
    "dark_prismarine": "dark_prismarine",
    "nether_brick": "nether_bricks",
    "red_nether_brick": "red_nether_bricks",
    "quartz": "quartz",
    "smooth_quartz": "smooth_quartz",
    "purpur": "purpur",
    "blackstone": "blackstone",
    "polished_blackstone": "polished_blackstone",
    "polished_blackstone_brick": "polished_blackstone_bricks",
    "deepslate": "deepslate",
    "cobbled_deepslate": "cobbled_deepslate",
    "polished_deepslate": "polished_deepslate",
    "deepslate_brick": "deepslate_bricks",
    "deepslate_tile": "deepslate_tiles",
    "tuff": "tuff",
    "polished_tuff": "polished_tuff",
    "tuff_brick": "tuff_bricks",
    "mud_brick": "mud_bricks"
}

base_path = ".idea/src/src/main/resources/assets/sideslabs"

# Create directories
os.makedirs(f"{base_path}/blockstates", exist_ok=True)
os.makedirs(f"{base_path}/models/block", exist_ok=True)
os.makedirs(f"{base_path}/models/item", exist_ok=True)

# 1. Parent Block Model
parent_model = {
    "parent": "minecraft:block/cube",
    "textures": {
        "particle": "#side"
    },
    "elements": [
        {
            "from": [0, 0, 0],
            "to": [8, 16, 16],
            "faces": {
                "north": {"uv": [8, 0, 16, 16], "texture": "#north"},
                "south": {"uv": [0, 0, 8, 16], "texture": "#south"},
                "east":  {"uv": [0, 0, 16, 16], "texture": "#east"},
                "west":  {"uv": [0, 0, 16, 16], "texture": "#west"},
                "up":    {"uv": [0, 0, 8, 16], "texture": "#up", "rotation": 90},
                "down":  {"uv": [0, 0, 8, 16], "texture": "#down", "rotation": 90}
            }
        }
    ]
}

with open(f"{base_path}/models/block/side_slab.json", "w") as f:
    json.dump(parent_model, f, indent=2)

# 2. Generate Blockstates + Models + Item Models
for name, texture in slabs.items():
    block_name = f"{name}_side_slab"

    # Blockstate
    blockstate = {
        "variants": {
            "facing=north": {"model": f"sideslabs:block/{block_name}"},
            "facing=east":  {"model": f"sideslabs:block/{block_name}", "y": 90},
            "facing=south": {"model": f"sideslabs:block/{block_name}", "y": 180},
            "facing=west":  {"model": f"sideslabs:block/{block_name}", "y": 270}
        }
    }
    with open(f"{base_path}/blockstates/{block_name}.json", "w") as f:
        json.dump(blockstate, f, indent=2)

    # Block Model
    model = {
        "parent": "sideslabs:block/side_slab",
        "textures": {
            "north": f"minecraft:block/{texture}",
            "south": f"minecraft:block/{texture}",
            "east":  f"minecraft:block/{texture}",
            "west":  f"minecraft:block/{texture}",
            "up":    f"minecraft:block/{texture}",
            "down":  f"minecraft:block/{texture}",
            "side":  f"minecraft:block/{texture}"
        }
    }
    with open(f"{base_path}/models/block/{block_name}.json", "w") as f:
        json.dump(model, f, indent=2)

    # Item Model
    item_model = {
        "parent": f"sideslabs:block/{block_name}"
    }
    with open(f"{base_path}/models/item/{block_name}.json", "w") as f:
        json.dump(item_model, f, indent=2)

print(f"✅ Successfully generated {len(slabs)} side slabs!")
print("   • Blockstates")
print("   • Block models")
print("   • Item models")
print("\nYou can now build the mod!")