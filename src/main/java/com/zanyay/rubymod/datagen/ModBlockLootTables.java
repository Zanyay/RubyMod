package com.zanyay.rubymod.datagen;

import com.zanyay.rubymod.block.ModBlocks;
import com.zanyay.rubymod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RUBY_BLOCK.get());

        add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
        add(ModBlocks.NETHERRACK_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHERRACK_RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
        add(ModBlocks.ENDSTONE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.ENDSTONE_RUBY_ORE.get(), ModItems.RAW_RUBY.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}