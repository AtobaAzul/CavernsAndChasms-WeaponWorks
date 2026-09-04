package net.atobaazul.cavernsandchasmsww;

import com.mojang.logging.LogUtils;
import net.atobaazul.cavernsandchasmsww.registries.CCWWItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static net.atobaazul.cavernsandchasmsww.registries.CCWWItems.*;

@Mod(CCWW.MOD_ID)
public class CCWW {
    public static final String MOD_ID = "ccww";
    public static final Logger LOGGER = LogUtils.getLogger();


    public CCWW() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        CCWWItems.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(NECROMIUM_HALBERD);
            event.accept(NECROMIUM_WARGLAIVE);
            event.accept(NECROMIUM_SCYTHE);
            event.accept(NECROMIUM_GREATSWORD);
            event.accept(NECROMIUM_HAMMER);
            event.accept(NECROMIUM_RAPIER);
            event.accept(NECROMIUM_KATANA);
            event.accept(NECROMIUM_MACE);
            event.accept(NECROMIUM_SPEAR);

            event.accept(SILVER_HALBERD);
            event.accept(SILVER_WARGLAIVE);
            event.accept(SILVER_SCYTHE);
            event.accept(SILVER_GREATSWORD);
            event.accept(SILVER_HAMMER);
            event.accept(SILVER_RAPIER);
            event.accept(SILVER_KATANA);
            event.accept(SILVER_MACE);
            event.accept(SILVER_SPEAR);

            event.accept(COPPER_HALBERD);
            event.accept(COPPER_WARGLAIVE);
            event.accept(COPPER_SCYTHE);
            event.accept(COPPER_GREATSWORD);
            event.accept(COPPER_HAMMER);
            event.accept(COPPER_RAPIER);
            event.accept(COPPER_KATANA);
            event.accept(COPPER_MACE);
            event.accept(COPPER_SPEAR);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
