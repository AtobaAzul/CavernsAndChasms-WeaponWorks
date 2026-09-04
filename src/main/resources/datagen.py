import json
import re

types = [
    "halberd",
    "warglaive",
    "scythe",
    "greatsword",
    "hammer",
    "rapier",
    "katana",
    "mace",
    "spear",
]

materials = [
    "copper",
    "exposed_copper",
    "weathered_copper",
    "oxidized_copper",
    "silver",
    "necromium",
]

recipe_dict = {
    "halberd": ["  A", " BA", "B  "],
    "warglaive": ["  A", " BA", "AA "],
    "scythe": [" AA", " BA", "B A"],
    "greatsword": [" A ", " A ", "ABA"],
    "hammer": [" AA", " BA", "B  "],
    "rapier": ["BAA"],
    "katana": ["  A", " A ", "B  "],
    "mace": [" A ", "ABA", " B "],
    "spear": ["  A", " B ", "B  "],
}

item_names = []

# Tags
with open(
    "data/caverns_and_chasms/tags/items/experience_boost_items.json", "w"
) as file:
    lang = {"values": []}
    for type in types:
        lang["values"].append("moonsweaponry:golden_" + type)
    json.dump(lang, file, indent=4)
    file.close()

with open("data/caverns_and_chasms/tags/items/magic_damage_items.json", "w") as file:
    lang = {"values": []}
    for type in types:
        lang["values"].append("ccww:silver_" + type)
    json.dump(lang, file, indent=4)
    file.close()

with open(
    "data/caverns_and_chasms/tags/items/slowness_inflicting_items.json", "w"
) as file:
    lang = {"values": []}

    for type in types:
        lang["values"].append("ccww:necromium_" + type)
    json.dump(lang, file, indent=4)
    file.close()


for type in types:
    # Model data
    for material in materials:
        item_name = f"{material}_{type}".format(type=type, material=material)
        item_names.append(item_name)

        # Copper waxed variants
        if "copper" in material:
            print("Creating waxed variant for: " + item_name)
            with open(
                "assets/ccww/models/item/waxed_" + item_name + ".json", "w"
            ) as file:
                lang = {
                    "parent": "ccww:item/" + item_name,
                }
                json.dump(lang, file, indent=4)
                file.close()

        model_file = open("assets/ccww/models/item/" + item_name + ".json", "w")
        model_data = """{{
  "parent": "minecraft:item/handheld",
  "loader": "forge:separate_transforms",
  "textures": {{
    "layer0": "ccww:item/{item_name}"
  }},
  "base": {{
    "parent": "moonsweaponry:item/{base}_{type}_handheld",
    "textures": {{
        "layer0": "ccww:item/{item_name}_handheld"
    }}
  }},
  "perspectives": {{
    "gui": {{
      "parent": "moonsweaponry:item/{base}_{type}_gui",
      "textures": {{
          "layer0": "ccww:item/{item_name}"
        }}
    }},
    "fixed": {{
      "parent": "moonsweaponry:item/{base}_{type}_gui",
      "textures": {{
          "layer0": "ccww:item/{item_name}"
        }}
    }},
    "ground": {{
      "parent": "moonsweaponry:item/{base}_{type}_gui",
      "textures": {{
          "layer0": "ccww:item/{item_name}"
        }}
    }}
  }}
}}"""

        model_data = model_data.format(
            item_name=item_name,
            base=("netherite" if material == "necromium" else "iron"),
            type=type,
        )

        if "copper" in material:
            model_data = model_data.replace("moonsweaponry:item/iron_hammer_handheld", "ccww:item/copper_hammer_handheld")

        model_file.writelines(model_data)
        print("Created model file for: " + item_name)
        model_file.close()

        # Better combat data
        weapon_attributes_file = open(
            "data/ccww/weapon_attributes/" + item_name + ".json", "w"
        )
        weapon_attributes_data = """{{
    "parent": "moonsweaponry:base/{type}"
}}"""
        weapon_attributes_data = weapon_attributes_data.format(type=type)
        weapon_attributes_file.writelines(weapon_attributes_data)
        print("Created weapon attributes file for: " + item_name)
        weapon_attributes_file.close()

        # recipes
        with open("data/ccww/recipes/" + item_name + ".json", "w") as file:
            crafting_material = ...

            if material =="copper": 
                crafting_material = "forge:storage_blocks/" + material
            elif "_" in material:
                crafting_material = "forge:storage_blocks/" + material.replace("block", "")
            else:
                crafting_material = "forge:ingots/" + material
            
            recipe = {
                "type": "minecraft:crafting_shaped",
                "pattern": recipe_dict[type],
                "key": {
                    "A": {"tag": crafting_material},
                    "B": {"tag": "forge:rods/wooden"},
                },
                "result": {"item": "ccww:" + item_name},
            }
            print("Created recipe for: " + item_name)
            json.dump(recipe, file, indent=4)
            file.close()

## Lang files.
lang = {}
_file = open("assets/ccww/lang/en_us.json", "w")
for name in item_names:
    lang["item.ccww."+name] = name.replace("_", " ").title()
json.dump(lang, _file, indent=4)
_file.close()