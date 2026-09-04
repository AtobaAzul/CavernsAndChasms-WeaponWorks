package net.atobaazul.cavernsandchasmsww.registries;

import com.teamabnormals.caverns_and_chasms.common.item.copper.WeatheringSwordItem;
import com.teamabnormals.caverns_and_chasms.core.other.CCTiers.CCItemTiers;
import net.atobaazul.cavernsandchasmsww.CCWW;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.minecraft.world.level.block.WeatheringCopper.WeatherState.*;
import static net.twomoonsstudios.moonsweaponry.constants.WeaponDataConstants.*;

public class CCWWItems {
    public static final Map<String, Tier> WEAPON_TIER_NAME_MAP = new HashMap<>();
    public static final Map<String, Float> ATK_SPEED = new HashMap<>();
    public static final Map<Tier, Integer> BASE_ATK_DMG = new HashMap<>(); //represents the base sword attack damage modifier.
    public static final Map<String, Integer> ATK_DMG_MOD = new HashMap<>(); //represents the difference between the sword to the type
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CCWW.MOD_ID);
    public static Map<String, WeatheringCopper.WeatherState> WEATHER_STATE_DEF = new HashMap<>();

    static {
        WEAPON_TIER_NAME_MAP.put("copper", CCItemTiers.COPPER);
        WEAPON_TIER_NAME_MAP.put("exposed_copper", CCItemTiers.EXPOSED_COPPER);
        WEAPON_TIER_NAME_MAP.put("weathered_copper", CCItemTiers.WEATHERED_COPPER);
        WEAPON_TIER_NAME_MAP.put("oxidized_copper", CCItemTiers.OXIDIZED_COPPER);
        WEAPON_TIER_NAME_MAP.put("silver", CCItemTiers.SILVER);
        WEAPON_TIER_NAME_MAP.put("necromium", CCItemTiers.NECROMIUM);

        WEATHER_STATE_DEF.put("copper", UNAFFECTED);
        WEATHER_STATE_DEF.put("exposed_copper", EXPOSED);
        WEATHER_STATE_DEF.put("weathered_copper", WEATHERED);
        WEATHER_STATE_DEF.put("oxidized_copper", OXIDIZED);

        ATK_SPEED.put("halberd", HALBERD_DEFAULT_ATK_SPD);
        ATK_SPEED.put("warglaive", WARGLAIVE_DEFAULT_ATK_SPD);
        ATK_SPEED.put("scythe", SCYTHE_DEFAULT_ATK_SPD);
        ATK_SPEED.put("greatsword", GREATSWORD_DEFAULT_ATK_SPD);
        ATK_SPEED.put("hammer", HAMMER_DEFAULT_ATK_SPD);
        ATK_SPEED.put("rapier", RAPIER_DEFAULT_ATK_SPD);
        ATK_SPEED.put("katana", KATANA_DEFAULT_ATK_SPD);
        ATK_SPEED.put("mace", MACE_DEFAULT_ATK_SPD);
        ATK_SPEED.put("spear", SPEAR_DEFAULT_ATK_SPD);

        BASE_ATK_DMG.put(CCItemTiers.COPPER, 3);
        BASE_ATK_DMG.put(CCItemTiers.EXPOSED_COPPER, 3);
        BASE_ATK_DMG.put(CCItemTiers.WEATHERED_COPPER, 3);
        BASE_ATK_DMG.put(CCItemTiers.OXIDIZED_COPPER, 3);
        BASE_ATK_DMG.put(CCItemTiers.SILVER, 1);
        BASE_ATK_DMG.put(CCItemTiers.NECROMIUM, 3);

        ATK_DMG_MOD.put("halberd", 1);
        ATK_DMG_MOD.put("warglaive", -2);
        ATK_DMG_MOD.put("scythe", 2);
        ATK_DMG_MOD.put("greatsword", 4);
        ATK_DMG_MOD.put("hammer", 3);
        ATK_DMG_MOD.put("rapier", -2);
        ATK_DMG_MOD.put("katana", -1);
        ATK_DMG_MOD.put("mace", 2);
        ATK_DMG_MOD.put("spear", -1);
    }

    //silver
    public static final RegistryObject<Item> SILVER_HALBERD = createWeapon("silver_halberd");
    public static final RegistryObject<Item> SILVER_WARGLAIVE = createWeapon("silver_warglaive");
    public static final RegistryObject<Item> SILVER_SCYTHE = createWeapon("silver_scythe");
    public static final RegistryObject<Item> SILVER_GREATSWORD = createWeapon("silver_greatsword");
    public static final RegistryObject<Item> SILVER_HAMMER = createWeapon("silver_hammer");
    public static final RegistryObject<Item> SILVER_RAPIER = createWeapon("silver_rapier");
    public static final RegistryObject<Item> SILVER_KATANA = createWeapon("silver_katana");
    public static final RegistryObject<Item> SILVER_MACE = createWeapon("silver_mace");
    public static final RegistryObject<Item> SILVER_SPEAR = createWeapon("silver_spear");

    //necromium
    public static final RegistryObject<Item> NECROMIUM_HALBERD = createWeapon("necromium_halberd");
    public static final RegistryObject<Item> NECROMIUM_WARGLAIVE = createWeapon("necromium_warglaive");
    public static final RegistryObject<Item> NECROMIUM_SCYTHE = createWeapon("necromium_scythe");
    public static final RegistryObject<Item> NECROMIUM_GREATSWORD = createWeapon("necromium_greatsword");
    public static final RegistryObject<Item> NECROMIUM_HAMMER = createWeapon("necromium_hammer");
    public static final RegistryObject<Item> NECROMIUM_RAPIER = createWeapon("necromium_rapier");
    public static final RegistryObject<Item> NECROMIUM_KATANA = createWeapon("necromium_katana");
    public static final RegistryObject<Item> NECROMIUM_MACE = createWeapon("necromium_mace");
    public static final RegistryObject<Item> NECROMIUM_SPEAR = createWeapon("necromium_spear");

    // copper stuff. Oh boy.
    public static final RegistryObject<Item> COPPER_HALBERD = createWeapon("copper_halberd");
    public static final RegistryObject<Item> EXPOSED_COPPER_HALBERD = createWeapon("exposed_copper_halberd");
    public static final RegistryObject<Item> WEATHERED_COPPER_HALBERD = createWeapon("weathered_copper_halberd");
    public static final RegistryObject<Item> OXIDIZED_COPPER_HALBERD = createWeapon("oxidized_copper_halberd");

    public static final RegistryObject<Item> COPPER_WARGLAIVE = createWeapon("copper_warglaive");
    public static final RegistryObject<Item> EXPOSED_COPPER_WARGLAIVE = createWeapon("exposed_copper_warglaive");
    public static final RegistryObject<Item> WEATHERED_COPPER_WARGLAIVE = createWeapon("weathered_copper_warglaive");
    public static final RegistryObject<Item> OXIDIZED_COPPER_WARGLAIVE = createWeapon("oxidized_copper_warglaive");

    public static final RegistryObject<Item> COPPER_SCYTHE = createWeapon("copper_scythe");
    public static final RegistryObject<Item> EXPOSED_COPPER_SCYTHE = createWeapon("exposed_copper_scythe");
    public static final RegistryObject<Item> WEATHERED_COPPER_SCYTHE = createWeapon("weathered_copper_scythe");
    public static final RegistryObject<Item> OXIDIZED_COPPER_SCYTHE = createWeapon("oxidized_copper_scythe");

    public static final RegistryObject<Item> COPPER_GREATSWORD = createWeapon("copper_greatsword");
    public static final RegistryObject<Item> EXPOSED_COPPER_GREATSWORD = createWeapon("exposed_copper_greatsword");
    public static final RegistryObject<Item> WEATHERED_COPPER_GREATSWORD = createWeapon("weathered_copper_greatsword");
    public static final RegistryObject<Item> OXIDIZED_COPPER_GREATSWORD = createWeapon("oxidized_copper_greatsword");

    public static final RegistryObject<Item> COPPER_HAMMER = createWeapon("copper_hammer");
    public static final RegistryObject<Item> EXPOSED_COPPER_HAMMER = createWeapon("exposed_copper_hammer");
    public static final RegistryObject<Item> WEATHERED_COPPER_HAMMER = createWeapon("weathered_copper_hammer");
    public static final RegistryObject<Item> OXIDIZED_COPPER_HAMMER = createWeapon("oxidized_copper_hammer");

    public static final RegistryObject<Item> COPPER_RAPIER = createWeapon("copper_rapier");
    public static final RegistryObject<Item> EXPOSED_COPPER_RAPIER = createWeapon("exposed_copper_rapier");
    public static final RegistryObject<Item> WEATHERED_COPPER_RAPIER = createWeapon("weathered_copper_rapier");
    public static final RegistryObject<Item> OXIDIZED_COPPER_RAPIER = createWeapon("oxidized_copper_rapier");

    public static final RegistryObject<Item> COPPER_KATANA = createWeapon("copper_katana");
    public static final RegistryObject<Item> EXPOSED_COPPER_KATANA = createWeapon("exposed_copper_katana");
    public static final RegistryObject<Item> WEATHERED_COPPER_KATANA = createWeapon("weathered_copper_katana");
    public static final RegistryObject<Item> OXIDIZED_COPPER_KATANA = createWeapon("oxidized_copper_katana");

    public static final RegistryObject<Item> COPPER_MACE = createWeapon("copper_mace");
    public static final RegistryObject<Item> EXPOSED_COPPER_MACE = createWeapon("exposed_copper_mace");
    public static final RegistryObject<Item> WEATHERED_COPPER_MACE = createWeapon("weathered_copper_mace");
    public static final RegistryObject<Item> OXIDIZED_COPPER_MACE = createWeapon("oxidized_copper_mace");

    public static final RegistryObject<Item> COPPER_SPEAR = createWeapon("copper_spear");
    public static final RegistryObject<Item> EXPOSED_COPPER_SPEAR = createWeapon("exposed_copper_spear");
    public static final RegistryObject<Item> WEATHERED_COPPER_SPEAR = createWeapon("weathered_copper_spear");
    public static final RegistryObject<Item> OXIDIZED_COPPER_SPEAR = createWeapon("oxidized_copper_spear");

    //waxed stuff
    public static final RegistryObject<Item> WAXED_COPPER_HALBERD = createWeapon("waxed_copper_halberd");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_HALBERD = createWeapon("waxed_exposed_copper_halberd");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_HALBERD = createWeapon("waxed_weathered_copper_halberd");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_HALBERD = createWeapon("waxed_oxidized_copper_halberd");

    public static final RegistryObject<Item> WAXED_COPPER_WARGLAIVE = createWeapon("waxed_copper_warglaive");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_WARGLAIVE = createWeapon("waxed_exposed_copper_warglaive");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_WARGLAIVE = createWeapon("waxed_weathered_copper_warglaive");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_WARGLAIVE = createWeapon("waxed_oxidized_copper_warglaive");

    public static final RegistryObject<Item> WAXED_COPPER_SCYTHE = createWeapon("waxed_copper_scythe");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_SCYTHE = createWeapon("waxed_exposed_copper_scythe");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_SCYTHE = createWeapon("waxed_weathered_copper_scythe");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_SCYTHE = createWeapon("waxed_oxidized_copper_scythe");

    public static final RegistryObject<Item> WAXED_COPPER_GREATSWORD = createWeapon("waxed_copper_greatsword");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_GREATSWORD = createWeapon("waxed_exposed_copper_greatsword");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_GREATSWORD = createWeapon("waxed_weathered_copper_greatsword");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_GREATSWORD = createWeapon("waxed_oxidized_copper_greatsword");

    public static final RegistryObject<Item> WAXED_COPPER_HAMMER = createWeapon("waxed_copper_hammer");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_HAMMER = createWeapon("waxed_exposed_copper_hammer");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_HAMMER = createWeapon("waxed_weathered_copper_hammer");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_HAMMER = createWeapon("waxed_oxidized_copper_hammer");

    public static final RegistryObject<Item> WAXED_COPPER_RAPIER = createWeapon("waxed_copper_rapier");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_RAPIER = createWeapon("waxed_exposed_copper_rapier");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_RAPIER = createWeapon("waxed_weathered_copper_rapier");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_RAPIER = createWeapon("waxed_oxidized_copper_rapier");

    public static final RegistryObject<Item> WAXED_COPPER_KATANA = createWeapon("waxed_copper_katana");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_KATANA = createWeapon("waxed_exposed_copper_katana");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_KATANA = createWeapon("waxed_weathered_copper_katana");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_KATANA = createWeapon("waxed_oxidized_copper_katana");

    public static final RegistryObject<Item> WAXED_COPPER_MACE = createWeapon("waxed_copper_mace");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_MACE = createWeapon("waxed_exposed_copper_mace");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_MACE = createWeapon("waxed_weathered_copper_mace");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_MACE = createWeapon("waxed_oxidized_copper_mace");

    public static final RegistryObject<Item> WAXED_COPPER_SPEAR = createWeapon("waxed_copper_spear");
    public static final RegistryObject<Item> WAXED_EXPOSED_COPPER_SPEAR = createWeapon("waxed_exposed_copper_spear");
    public static final RegistryObject<Item> WAXED_WEATHERED_COPPER_SPEAR = createWeapon("waxed_weathered_copper_spear");
    public static final RegistryObject<Item> WAXED_OXIDIZED_COPPER_SPEAR = createWeapon("waxed_oxidized_copper_spear");


    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

    public static RegistryObject<Item> createWeapon(String name) {
        String tier = name.split("_(halberd|warglaive|scythe|greatsword|hammer|rapier|katana|mace|spear)")[0].replace("waxed_", "");
        String type = name.split("(.*copper|silver|necromium)_")[1];

        CCWW.LOGGER.info("name: {}", name);
        CCWW.LOGGER.info("tier: {}", tier);
        CCWW.LOGGER.info("type: {}", type);
        CCWW.LOGGER.info("actual tier: {}", WEAPON_TIER_NAME_MAP.get(tier));
        CCWW.LOGGER.info("base attack damage: {}", BASE_ATK_DMG.get(WEAPON_TIER_NAME_MAP.get(tier)));
        CCWW.LOGGER.info("attack damage modifier: {}", ATK_DMG_MOD.get(type));
        CCWW.LOGGER.info("attack speed: {}", ATK_SPEED.get(type));


        if (name.matches("waxed") || !name.matches(".*copper.*")) {
            CCWW.LOGGER.info("Registering {} as SwordItem", name);
            return ITEMS.register(name, () -> new SwordItem(WEAPON_TIER_NAME_MAP.get(tier), BASE_ATK_DMG.get(WEAPON_TIER_NAME_MAP.get(tier)) + ATK_DMG_MOD.get(type), ATK_SPEED.get(type), new Item.Properties()

            ));
        } else {
            CCWW.LOGGER.info("Registering {} as WeatheringSwordItem", name);

            return ITEMS.register(name, () -> new WeatheringSwordItem(WEATHER_STATE_DEF.get(tier), WEAPON_TIER_NAME_MAP.get(tier), BASE_ATK_DMG.get(WEAPON_TIER_NAME_MAP.get(tier)) + ATK_DMG_MOD.get(type), ATK_SPEED.get(type), new Item.Properties()

            ));
        }
    }
}
