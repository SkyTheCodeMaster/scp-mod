package com.skythecodemaster.scp.common.registry;

import com.skythecodemaster.scp.SkySCPMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {
  public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister
    .create(ForgeRegistries.SOUND_EVENTS, SkySCPMod.MOD_ID);
  private static RegistryObject<SoundEvent> register(String name, ResourceLocation location) {
    return SOUNDS.register(name,()->new SoundEvent(location));
  }
  
  public static final RegistryObject<SoundEvent> HEAVY_DOOR_OLD_OPEN_SOUND = register(
    "heavy_door_old_open",new ResourceLocation(SkySCPMod.MOD_ID,"heavy_door_old_open")
  );
  
  public static final RegistryObject<SoundEvent> HEAVY_DOOR_OLD_CLOSE_SOUND = register(
    "heavy_door_old_close",new ResourceLocation(SkySCPMod.MOD_ID,"heavy_door_old_close")
  );
}
