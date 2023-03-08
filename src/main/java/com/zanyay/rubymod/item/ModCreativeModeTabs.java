package com.zanyay.rubymod.item;

import com.zanyay.rubymod.RubyMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RubyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab RUBY_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        RUBY_TAB = event.registerCreativeModeTab(new ResourceLocation(RubyMod.MOD_ID, "ruby_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RUBY.get())).title(Component.translatable("creativemodetab.ruby_tab")));
    }
}
