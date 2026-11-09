package uk.co.extraspecialstudio.dead_air_block_beats_fm;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
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

    public Dead_air_block_beats_fm(IEventBus modEventBus) {
        modEventBus.addListener(this::onRegister);
    }

    private void onRegister(RegisterEvent event) {
        event.register(Registries.SOUND_EVENT, registry -> {
            for (String slug : TRACK_SLUGS) {
                ResourceLocation id = new ResourceLocation(MODID, "music." + slug);
                registry.register(id, SoundEvent.createVariableRangeEvent(id));
            }
        });
        LOGGER.info("[Block Beats FM] Registered {} tracks.", TRACK_SLUGS.size());
    }
}
