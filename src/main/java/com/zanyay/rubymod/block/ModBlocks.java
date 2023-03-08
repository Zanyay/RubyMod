package com.zanyay.rubymod.block;

import com.zanyay.rubymod.RubyMod;
import com.zanyay.rubymod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RubyMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block", ()-> new Block(BlockBehaviour.Properties.of(Material.METAL)
            .strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore", ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore", ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(8f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));
    public static final RegistryObject<Block> NETHERRACK_RUBY_ORE = registerBlock("netherrack_ruby_ore", ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));
    public static final RegistryObject<Block> ENDSTONE_RUBY_ORE = registerBlock("endstone_ruby_ore", ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
            .strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
