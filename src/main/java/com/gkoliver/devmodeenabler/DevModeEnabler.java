package com.gkoliver.devmodeenabler;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedConstants;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("devmodeenabler")
public class DevModeEnabler
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public DevModeEnabler() {
        DeferredWorkQueue.runLater(()->{
            SharedConstants.developmentMode = true;
        });
        DeferredWorkQueue.runLater(()->{
            if (ModList.get().size()>1) {
                LOGGER.warn("WARNING: You have Development Mode Enabler in your mod set, along with other mods. This mod will likely break all other mods, because of reasons out of my control.");
            }
        });
    }
}
