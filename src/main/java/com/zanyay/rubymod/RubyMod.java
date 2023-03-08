package com.zanyay.rubymod;

import com.mojang.logging.LogUtils;
import com.zanyay.rubymod.block.ModBlocks;
import com.zanyay.rubymod.item.ModCreativeModeTabs;
import com.zanyay.rubymod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(RubyMod.MOD_ID)
public class RubyMod {
    public static final String MOD_ID = "rubymod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public RubyMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }
//gaming
    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    //yes
    private void addCreative(CreativeModeTabEvent.BuildContents event){
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.RUBY);
            event.accept(ModItems.RAW_RUBY);
        }

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.RUBY_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.NETHERRACK_RUBY_ORE);
            event.accept(ModBlocks.ENDSTONE_RUBY_ORE);
        }

        if(event.getTab() == ModCreativeModeTabs.RUBY_TAB){
            event.accept(ModItems.RUBY);
            event.accept(ModItems.RAW_RUBY);
            event.accept(ModBlocks.RUBY_BLOCK);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.NETHERRACK_RUBY_ORE);
            event.accept(ModBlocks.ENDSTONE_RUBY_ORE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}