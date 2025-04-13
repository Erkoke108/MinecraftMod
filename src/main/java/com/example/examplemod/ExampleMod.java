package com.example.examplemod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Registries;
import net.minecraftforge.eventbus.api.Mod;
import net.minecraftforge.event.CreativeModeTabContentsEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.CreativeModeTabAddItemEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(ExampleMod.MODID)
public class ExampleMod {
    public static final String MODID = "minecraftmod";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, MODID);

    // Block and item registry objects
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).mapColor(MapColor.STONE)));
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
            () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    // Creative tab registry object
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder().title(new TextComponent("Example Tab"))
                    .icon(() -> new Item(EXAMPLE_BLOCK_ITEM.get()))
                    .build());

    public ExampleMod() {
        IEventBus modEventBus = MinecraftForge.EVENT_BUS;
        IEventBus forgeBus = Minecraft.getInstance().getForgeBus();

        modEventBus.addListener(this::addCreative); // Register for Creative Tab contents

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the EventBus so that all objects are
        // registered
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LogUtils.getLogger().info("HELLO FROM COMMON SETUP");
        LogUtils.getLogger().info("Mojang API version is {}", Minecraft.getInstance().getVersion());
    }

    private void addCreative(CreativeModeTabContentsEvent event) {
        if (event.getTabKey() == EXAMPLE_TAB.get()) {
            event.addItem(EXAMPLE_BLOCK_ITEM.get());
        }
    }

    // You can use SubscribeEvent to let the Forge run some common code, like mod
    // setup and world generation
    // This will use an annotation to let you specify when a method should run
    // (i.e., during modloading)
    @SubscribeEvent
    public void onCreativeModeTabRegistration(CreativeModeTabAddItemEvent event) {
        // You can add items to the tab here
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister
            .create(ForgeRegistries.CREATIVE_MODE_TABS, MODID);
}
