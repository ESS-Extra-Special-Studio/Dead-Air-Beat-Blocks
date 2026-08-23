package uk.co.extraspecialstudio.dead_air_block_beats_fm;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

import java.util.List;

@Mod(Dead_air_block_beats_fm.MODID)
public class Dead_air_block_beats_fm {
    public static final String MODID = "dead_air_block_beats_fm";
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<String> TRACK_SLUGS = List.of(
        "4th_broadway",
        "beat_blocks",
        "block_by_block",
        "blue_orchid",
        "brewing_patience",
        "bro_s_in_creative_mode",
        "cheeky_taxi_rides",
        "craftworld",
        "curb_side_reverb",
        "diamonds_and_ender_pearls",
        "don_t_forget",
        "echoes_in_the_ravine",
        "harlem_after_hours",
        "late_check_in",
        "let_s_start_a_new_world",
        "love_tap_boom_bap",
        "my_little_secret",
        "my_minecraft_mod",
        "ocean_guardian",
        "oh_yeah",
        "satin_sidewalks",
        "southside_satin",
        "steve_s_getting_stacked",
        "street_prophet",
        "tenement_yard"
    );

    public Dead_air_block_beats_fm() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        if (!event.getRegistryKey().equals(ForgeRegistries.Keys.SOUND_EVENTS)) {
            return;
        }
        for (String slug : TRACK_SLUGS) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MODID, "music." + slug);
            event.register(ForgeRegistries.Keys.SOUND_EVENTS, id, () -> SoundEvent.createVariableRangeEvent(id));
        }
        LOGGER.info("[Block Beats FM] Registered {} music tracks.", TRACK_SLUGS.size());
    }
}