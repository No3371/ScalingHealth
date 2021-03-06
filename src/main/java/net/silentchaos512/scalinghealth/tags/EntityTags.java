package net.silentchaos512.scalinghealth.tags;

import net.minecraft.entity.EntityType;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ITag;
import net.silentchaos512.scalinghealth.ScalingHealth;

public class EntityTags {
   public static final ITag.INamedTag<EntityType<?>> DIFFICULTY_EXEMPT = EntityTypeTags.func_232896_a_(ScalingHealth.getId("difficulty_exempt").toString());
   public static final ITag.INamedTag<EntityType<?>> BLIGHT_EXEMPT = EntityTypeTags.func_232896_a_(ScalingHealth.getId("blight_exempt").toString());
}
