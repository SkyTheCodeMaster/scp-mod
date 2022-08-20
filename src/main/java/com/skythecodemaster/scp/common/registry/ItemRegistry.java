package com.skythecodemaster.scp.common.registry;

import com.skythecodemaster.scp.SkySCPMod;
import com.skythecodemaster.scp.common.items.ScpeniumItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkySCPMod.MOD_ID);
  
  // SCPenium Block
  public static final RegistryObject<BlockItem> SCPENIUM_BLOCK_ITEM = ITEMS.register("scpenium_block",
    () -> new BlockItem(BlockRegistry.SCPENIUM_BLOCK.get(),
      new Item.Properties().tab(SkySCPMod.scpTab)));
  
  // SCPenium item
  public static final RegistryObject<Item> SCPENIUM = ITEMS.register("scpenium",
    () -> new ScpeniumItem());
  
  // Light Door (Old)
  public static final RegistryObject<BlockItem> LIGHT_DOOR_OLD_ITEM = ITEMS.register("light_door_old",
    () -> new BlockItem(BlockRegistry.LIGHT_DOOR_OLD.get(),
      new Item.Properties().tab(SkySCPMod.scpTab)));
  
  // Light Door (New)
  //public static final RegistryObject<BlockItem> LIGHT_DOOR_NEW_ITEM = ITEMS.register("light_door_new",
  //  () -> new BlockItem(BlockRegistry.LIGHT_DOOR_NEW.get(),
  //    new Item.Properties().tab(SkySCPMod.scpTab)));
  
  // Heavy Door (Old)
  public static final RegistryObject<BlockItem> HEAVY_DOOR_OLD_ITEM = ITEMS.register("heavy_door_old",
    () -> new BlockItem(BlockRegistry.HEAVY_DOOR_OLD.get(),
      new Item.Properties().tab(SkySCPMod.scpTab)));
}
