package net.silentchaos512.scalinghealth.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.silentchaos512.scalinghealth.ScalingHealth;

@Mod.EventBusSubscriber(modid = ScalingHealth.MOD_ID ,bus = Mod.EventBusSubscriber.Bus.MOD)
public class GenEvent {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new Recipes(generator));
        generator.addProvider(new LootTables(generator));
        generator.addProvider(new SHEntityTags(event));
        generator.addProvider(new LootModifierGen(event.getGenerator()));
    }
}
