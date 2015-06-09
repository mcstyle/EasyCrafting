package net.lepko.easycrafting.core.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.lepko.easycrafting.Ref;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@GameRegistry.ObjectHolder(Ref.MOD_ID)
public class ModBlocks {

    public static final Block table = new BlockTable();

    public static void setupBlocks() {
        GameRegistry.registerBlock(table, ItemBlockTable.class, "table");
        GameRegistry.registerCustomItemStack("easyCraftingTable", new ItemStack(table, 1, 0));
        GameRegistry.registerCustomItemStack("autoCraftingTable", new ItemStack(table, 1, 1));

        GameRegistry.registerTileEntity(TileEntityEasyCrafting.class, "EasyCraftingTableTE");
        GameRegistry.registerTileEntity(TileEntityAutoCrafting.class, "AutoCraftingTableTE");
    }

    public static void setupRecipes() {
        GameRegistry.addShapelessRecipe(get("easyCraftingTable"), Blocks.crafting_table, Items.redstone, Items.book);
        GameRegistry.addShapedRecipe(get("autoCraftingTable"), "rxr", "scs", "rir", 'r', Items.redstone, 'x', ic2.api.item.IC2Items.getItem("electronicCircuit"), 's', ic2.api.item.IC2Items.getItem("ironCableItem"), 'i', Items.iron_ingot, 'c', Blocks.crafting_table);
    }

    private static ItemStack get(String name) {
        return GameRegistry.findItemStack(Ref.MOD_ID, name, 1);
    }
}
