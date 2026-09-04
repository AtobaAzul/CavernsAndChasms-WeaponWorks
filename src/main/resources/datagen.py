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


def create_item_tag(tag: str, items: list):
    """Creates an item tag for the given list of items

    Args:
        tag (str): The tag to create
        items (list): The items to add to the tag
    """

    mod = tag.split(":")[0]
    _tag = tag.split(":")[1]
    with open("data/" + mod + "/tags/items/" + _tag + ".json", "w") as file:
        data = {"values": items}
        json.dump(data, file, indent=4)
        file.close()


########## Tags
exp_boost_items = []
magic_dmg_items = []
slowness_items = []

for type in types:
    exp_boost_items.append("moonsweaponry:golden_" + type)
    magic_dmg_items.append("ccww:silver_" + type)
    slowness_items.append("ccww:necromium_" + type)

create_item_tag(
    "caverns_and_chasms:experience_boost_items", ["moonsweaponry:golden_" + type]
)
create_item_tag("caverns_and_chasms:magic_damage_items", ["ccww:silver_" + type])
create_item_tag(
    "caverns_and_chasms:slowness_inflicting_items", ["ccww:necromium_" + type]
)

########## Models

model_data_str = """{{
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


def create_weapon_model_data(type: str, material: str):
    item_name = f"{material}_{type}".format(type=type, material=material)
    item_names.append(item_name)

    # Copper waxed variants
    if "copper" in material:
        model_file = open("assets/ccww/models/item/waxed_" + item_name + ".json", "w")
        model_data = model_data_str.format(
            item_name=item_name,
            base=("netherite" if material == "necromium" else "iron"),
            type=type,
        )

        if "copper" in material:
            model_data = model_data.replace(
                "moonsweaponry:item/iron_hammer_handheld",
                "ccww:item/copper_hammer_handheld",
            )

        model_file.writelines(model_data)
        print("Created waxed model file for: " + item_name)
        model_file.close()
    
    # Normal models
    model_file = open("assets/ccww/models/item/" + item_name + ".json", "w")

    model_data = model_data_str.format(
        item_name=item_name,
        base=("netherite" if material == "necromium" else "iron"),
        type=type,
    )

    if "copper" in material:
        model_data = model_data.replace(
            "moonsweaponry:item/iron_hammer_handheld",
            "ccww:item/copper_hammer_handheld",
        )

    model_file.writelines(model_data)
    print("Created model file for: " + item_name)
    model_file.close()


########## Weapon attributes
def create_weapon_attributes(type: str, material: str):
    item_name = f"{material}_{type}".format(type=type, material=material)
    file = open("data/ccww/weapon_attributes/" + item_name + ".json", "w")
    data = {
        "parent": "moonsweaponry:base/" + type,
    }
    json.dump(data, file, indent=4)
    print("Created weapon attributes file for: " + item_name)
    file.close()


########## Recipes
def create_weapon_shaped_recipe(type: str, material: str, ingredient: str, tag: bool):

    item_name = f"{material}_{type}".format(type=type, material=material)

    file = open("data/ccww/recipes/crafting/" + item_name + ".json", "w")
    data = {
        "type": "minecraft:crafting_shaped",
        "pattern": recipe_dict[type],
        "key": {
            "B": {"tag": "forge:rods/wooden"},
        },
        "result": {"item": "ccww:" + item_name},
    }
    data["key"]["A"] = {"tag": ingredient} if tag else {"item": ingredient}
    json.dump(data, file, indent=4)
    print("Created recipe file for: " + item_name)
    file.close()


def create_weapon_smithing_recipe(type: str, material: str, ingredient: str, base: str):
    item_name = f"{material}_{type}".format(type=type, material=material)

    file = open("data/ccww/recipes/smithing/" + item_name + ".json", "w")
    data = {
        "type": "minecraft:smithing",
        "base": {"item": base},
        "addition": {"item": ingredient},
        "result": {"item": "ccww:" + item_name},
    }
    json.dump(data, file, indent=4)
    print("Created smithing recipe file for: " + item_name)
    file.close()


for type in types:
    # Model data
    for material in materials:
        item_name = f"{material}_{type}".format(type=type, material=material)
        item_names.append(item_name)  # For lang file creation.

        create_weapon_model_data(type, material)
        create_weapon_attributes(type, material)
        # Recipes
        if "copper" in material:
            create_weapon_shaped_recipe(
                type,
                material,
                (
                    "minecraft:copper_block"
                    if material == "copper"
                    else "minecraft:" + material
                ),
                False,
            )
            create_weapon_shaped_recipe(
                type,
                "waxed_" + material,
                (
                    "minecraft:waxed_copper_block"
                    if material == "copper"
                    else "minecraft:waxed_" + material
                ),
                False,
            )
        elif material == "necromium":
            create_weapon_smithing_recipe(
                type,
                material,
                "caverns_and_chasms:necromium_ingot",
                "moonsweaponry:diamond_" + type,
            )
        else:
            create_weapon_shaped_recipe(type, material, "forge:ingots/silver", True)

## Lang files.
lang = {}
_file = open("assets/ccww/lang/en_us.json", "w")
for name in item_names:
    lang["item.ccww." + name] = name.replace("_", " ").title()
    if "copper" in name:
        lang["item.ccww.waxed_" + name] = "Waxed " + name.replace("_", " ").title()
json.dump(lang, _file, indent=4)
_file.close()
