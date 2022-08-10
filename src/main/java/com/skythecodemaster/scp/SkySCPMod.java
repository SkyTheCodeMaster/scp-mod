package com.skythecodemaster.scp;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.client.renderers.LightDoorOldRenderer;
import com.skythecodemaster.scp.common.setup.BlockEntityTypes;
import com.skythecodemaster.scp.common.setup.Blocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.server.ServerStartingEvent;
import com.skythecodemaster.scp.common.setup.Registration;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SkySCPMod.MOD_ID)
public class SkySCPMod
{
    public static final String MOD_ID = "skysscp";
    public static final CreativeModeTab TAB = new CreativeModeTab("skysscptab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Blocks.GENERIC_BLOCK.get());
        }
    };
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public SkySCPMod()
    {
        LOGGER.info("SCP: Secure, Contain, Protect");
        
        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(BlockEntityTypes.LIGHT_DOOR_OLD_TILE.get(), LightDoorOldRenderer::new);
        }
    }
}
