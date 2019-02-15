/*
 * Scaling Health
 * Copyright (C) 2018 SilentChaos512
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 3
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.silentchaos512.scalinghealth.init;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.silentchaos512.scalinghealth.ScalingHealth;
import net.silentchaos512.scalinghealth.potion.PotionBandaged;
import net.silentchaos512.utils.Lazy;

import java.util.Locale;
import java.util.function.Supplier;

public enum ModPotions {
    BANDAGED(PotionBandaged::new);

    private final Lazy<Potion> potion;

    ModPotions(Supplier<Potion> factory) {
        this.potion = Lazy.of(factory);
    }

    public Potion get() {
        return potion.get();
    }

    public String getName() {
        return name().toLowerCase(Locale.ROOT);
    }

    public static void registerAll(RegistryEvent.Register<Potion> event) {
        // Workaround for Forge event bus bug
        if (!event.getName().equals(ForgeRegistries.POTIONS.getRegistryName())) return;

        for (ModPotions potion : values()) {
            register(potion.getName(), potion.get());
        }
    }

    private static void register(String name, Potion potion) {
        ResourceLocation registryName = new ResourceLocation(ScalingHealth.MOD_ID, name);
        potion.setRegistryName(registryName);
        ForgeRegistries.POTIONS.register(potion);
    }
}
