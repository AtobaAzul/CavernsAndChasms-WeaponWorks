package net.atobaazul.cavernsandchasmsww.mixin;

import com.google.common.collect.ImmutableBiMap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.teamabnormals.caverns_and_chasms.common.item.copper.WeatheringCopperItem;
import net.atobaazul.cavernsandchasmsww.registries.CCWWItems;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static net.atobaazul.cavernsandchasmsww.registries.CCWWItems.*;

//Credit: Gloves for All
@Mixin(WeatheringCopperItem.class)
public interface WeatheringCopperItemMixin {
    @ModifyExpressionValue(
            method = "lambda$static$0",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/google/common/collect/ImmutableBiMap;builder()Lcom/google/common/collect/ImmutableBiMap$Builder;"
            ),
            remap = false
    )
    private static ImmutableBiMap.Builder<Item, Item> ccww$injectNextByItem(ImmutableBiMap.Builder<Item, Item> original) {
        return original
                .put(COPPER_HALBERD.get(), EXPOSED_COPPER_HALBERD.get())
                .put(EXPOSED_COPPER_HALBERD.get(), WEATHERED_COPPER_HALBERD.get())
                .put(WEATHERED_COPPER_HALBERD.get(), OXIDIZED_COPPER_HALBERD.get())
                .put(COPPER_WARGLAIVE.get(), EXPOSED_COPPER_WARGLAIVE.get())
                .put(EXPOSED_COPPER_WARGLAIVE.get(), WEATHERED_COPPER_WARGLAIVE.get())
                .put(WEATHERED_COPPER_WARGLAIVE.get(), OXIDIZED_COPPER_WARGLAIVE.get())
                .put(COPPER_SCYTHE.get(), EXPOSED_COPPER_SCYTHE.get())
                .put(EXPOSED_COPPER_SCYTHE.get(), WEATHERED_COPPER_SCYTHE.get())
                .put(WEATHERED_COPPER_SCYTHE.get(), OXIDIZED_COPPER_SCYTHE.get())
                .put(COPPER_GREATSWORD.get(), EXPOSED_COPPER_GREATSWORD.get())
                .put(EXPOSED_COPPER_GREATSWORD.get(), WEATHERED_COPPER_GREATSWORD.get())
                .put(WEATHERED_COPPER_GREATSWORD.get(), OXIDIZED_COPPER_GREATSWORD.get())
                .put(COPPER_HAMMER.get(), EXPOSED_COPPER_HAMMER.get())
                .put(EXPOSED_COPPER_HAMMER.get(), WEATHERED_COPPER_HAMMER.get())
                .put(WEATHERED_COPPER_HAMMER.get(), OXIDIZED_COPPER_HAMMER.get())
                .put(COPPER_RAPIER.get(), EXPOSED_COPPER_RAPIER.get())
                .put(EXPOSED_COPPER_RAPIER.get(), WEATHERED_COPPER_RAPIER.get())
                .put(WEATHERED_COPPER_RAPIER.get(), OXIDIZED_COPPER_RAPIER.get())
                .put(COPPER_KATANA.get(), EXPOSED_COPPER_KATANA.get())
                .put(EXPOSED_COPPER_KATANA.get(), WEATHERED_COPPER_KATANA.get())
                .put(WEATHERED_COPPER_KATANA.get(), OXIDIZED_COPPER_KATANA.get())
                .put(COPPER_MACE.get(), EXPOSED_COPPER_MACE.get())
                .put(EXPOSED_COPPER_MACE.get(), WEATHERED_COPPER_MACE.get())
                .put(WEATHERED_COPPER_MACE.get(), OXIDIZED_COPPER_MACE.get())
                .put(COPPER_SPEAR.get(), EXPOSED_COPPER_SPEAR.get())
                .put(EXPOSED_COPPER_SPEAR.get(), WEATHERED_COPPER_SPEAR.get())
                .put(WEATHERED_COPPER_SPEAR.get(), OXIDIZED_COPPER_SPEAR.get());

    }

    @ModifyExpressionValue(
            method = "lambda$static$2",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/google/common/collect/ImmutableBiMap;builder()Lcom/google/common/collect/ImmutableBiMap$Builder;"
            ),
            remap = false
    )
    private static ImmutableBiMap.Builder<Item, Item> ccww$injectWaxables(ImmutableBiMap.Builder<Item, Item> original) {
        return original
                .put(COPPER_HALBERD.get(), WAXED_COPPER_HALBERD.get())
                .put(COPPER_WARGLAIVE.get(), WAXED_COPPER_WARGLAIVE.get())
                .put(COPPER_SCYTHE.get(), WAXED_COPPER_SCYTHE.get())
                .put(COPPER_GREATSWORD.get(), WAXED_COPPER_GREATSWORD.get())
                .put(COPPER_HAMMER.get(), WAXED_COPPER_HAMMER.get())
                .put(COPPER_RAPIER.get(), WAXED_COPPER_RAPIER.get())
                .put(COPPER_KATANA.get(), WAXED_COPPER_KATANA.get())
                .put(COPPER_MACE.get(), WAXED_COPPER_MACE.get())
                .put(COPPER_SPEAR.get(), WAXED_COPPER_SPEAR.get())
                .put(EXPOSED_COPPER_HALBERD.get(), WAXED_EXPOSED_COPPER_HALBERD.get())
                .put(EXPOSED_COPPER_WARGLAIVE.get(), WAXED_EXPOSED_COPPER_WARGLAIVE.get())
                .put(EXPOSED_COPPER_SCYTHE.get(), WAXED_EXPOSED_COPPER_SCYTHE.get())
                .put(EXPOSED_COPPER_GREATSWORD.get(), WAXED_EXPOSED_COPPER_GREATSWORD.get())
                .put(EXPOSED_COPPER_HAMMER.get(), WAXED_EXPOSED_COPPER_HAMMER.get())
                .put(EXPOSED_COPPER_RAPIER.get(), WAXED_EXPOSED_COPPER_RAPIER.get())
                .put(EXPOSED_COPPER_KATANA.get(), WAXED_EXPOSED_COPPER_KATANA.get())
                .put(EXPOSED_COPPER_MACE.get(), WAXED_EXPOSED_COPPER_MACE.get())
                .put(EXPOSED_COPPER_SPEAR.get(), WAXED_EXPOSED_COPPER_SPEAR.get())
                .put(WEATHERED_COPPER_HALBERD.get(), WAXED_WEATHERED_COPPER_HALBERD.get())
                .put(WEATHERED_COPPER_WARGLAIVE.get(), WAXED_WEATHERED_COPPER_WARGLAIVE.get())
                .put(WEATHERED_COPPER_SCYTHE.get(), WAXED_WEATHERED_COPPER_SCYTHE.get())
                .put(WEATHERED_COPPER_GREATSWORD.get(), WAXED_WEATHERED_COPPER_GREATSWORD.get())
                .put(WEATHERED_COPPER_HAMMER.get(), WAXED_WEATHERED_COPPER_HAMMER.get())
                .put(WEATHERED_COPPER_RAPIER.get(), WAXED_WEATHERED_COPPER_RAPIER.get())
                .put(WEATHERED_COPPER_KATANA.get(), WAXED_WEATHERED_COPPER_KATANA.get())
                .put(WEATHERED_COPPER_MACE.get(), WAXED_WEATHERED_COPPER_MACE.get())
                .put(WEATHERED_COPPER_SPEAR.get(), WAXED_WEATHERED_COPPER_SPEAR.get())
                .put(OXIDIZED_COPPER_HALBERD.get(), WAXED_OXIDIZED_COPPER_HALBERD.get())
                .put(OXIDIZED_COPPER_WARGLAIVE.get(), WAXED_OXIDIZED_COPPER_WARGLAIVE.get())
                .put(OXIDIZED_COPPER_SCYTHE.get(), WAXED_OXIDIZED_COPPER_SCYTHE.get())
                .put(OXIDIZED_COPPER_GREATSWORD.get(), WAXED_OXIDIZED_COPPER_GREATSWORD.get())
                .put(OXIDIZED_COPPER_HAMMER.get(), WAXED_OXIDIZED_COPPER_HAMMER.get())
                .put(OXIDIZED_COPPER_RAPIER.get(), WAXED_OXIDIZED_COPPER_RAPIER.get())
                .put(OXIDIZED_COPPER_KATANA.get(), WAXED_OXIDIZED_COPPER_KATANA.get())
                .put(OXIDIZED_COPPER_MACE.get(), WAXED_OXIDIZED_COPPER_MACE.get())
                .put(OXIDIZED_COPPER_SPEAR.get(), WAXED_OXIDIZED_COPPER_SPEAR.get());
    }

}
