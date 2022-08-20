package com.skythecodemaster.scp.common.registry;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blockentities.HeavyDoorOldBlockEntity;
import com.skythecodemaster.scp.common.blockentities.LightDoorOldBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TileRegistry {
  public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister
    .create(ForgeRegistries.BLOCK_ENTITIES, SkySCPMod.MOD_ID);
  
  public static final RegistryObject<BlockEntityType<LightDoorOldBlockEntity>> LIGHT_DOOR_OLD_ENTITY = TILES
    .register("light_door_tile", () -> BlockEntityType.Builder
      .of(LightDoorOldBlockEntity::new, BlockRegistry.LIGHT_DOOR_OLD.get()).build(null));
  
  //public static final RegistryObject<BlockEntityType<LightDoorNewBlockEntity>> LIGHT_DOOR_NEW_ENTITY = TILES
  //  .register("light_door_new_tile", () -> BlockEntityType.Builder
  //    .of(LightDoorNewBlockEntity::new, BlockRegistry.LIGHT_DOOR_NEW.get()).build(null));
  
  public static final RegistryObject<BlockEntityType<HeavyDoorOldBlockEntity>> HEAVY_DOOR_OLD_ENTITY = TILES
    .register("heavy_door_old_tile", () -> BlockEntityType.Builder
      .of(HeavyDoorOldBlockEntity::new, BlockRegistry.HEAVY_DOOR_OLD.get()).build(null));
}
