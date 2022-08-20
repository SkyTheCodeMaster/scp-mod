package com.skythecodemaster.scp.common.registry;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.blocks.HeavyDoorOld;
import com.skythecodemaster.scp.common.blocks.ScpeniumBlock;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SkySCPMod.MOD_ID);
  
  public static final RegistryObject<ScpeniumBlock> SCPENIUM_BLOCK = BLOCKS.register("scpenium_block",
    ScpeniumBlock::new);
  public static final RegistryObject<LightDoorOld> LIGHT_DOOR_OLD = BLOCKS.register("light_door_old",
    LightDoorOld::new);
  //public static final RegistryObject<LightDoorNew> LIGHT_DOOR_NEW = BLOCKS.register("light_door_new",
  //  LightDoorNew::new);
  public static final RegistryObject<HeavyDoorOld> HEAVY_DOOR_OLD = BLOCKS.register("heavy_door_old",
    HeavyDoorOld::new);
}
