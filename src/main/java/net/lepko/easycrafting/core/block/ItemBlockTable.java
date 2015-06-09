package net.lepko.easycrafting.core.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.lepko.easycrafting.Ref;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemBlockTable extends ItemBlock {

    public ItemBlockTable(Block block) {
        super(block);
        setUnlocalizedName(Ref.addDomain("table"));
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        if (meta >= 0 && meta < BlockTable.names.length) {
            return this.getUnlocalizedName() + "." + BlockTable.names[meta];
        }
        return "missingno";
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4)
    {
        String info = I18n.format(String.format("tile.easycrafting:table.%s.info", BlockTable.names[is.getItemDamage()]));
        if (info.length() > 0) {
            list.add(info);
        }

    }
}
