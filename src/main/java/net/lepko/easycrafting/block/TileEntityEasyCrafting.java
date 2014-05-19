package net.lepko.easycrafting.block;

import net.lepko.easycrafting.util.InventoryUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityEasyCrafting extends TileEntity implements IInventory {

    private ItemStack[] inventory;

    public TileEntityEasyCrafting() {
        inventory = new ItemStack[40 + 18]; // 40 = 5*8 crafting slots, 18 = 2*9 inventory slots
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIndex) {
        return inventory[slotIndex];
    }

    @Override
    public void setInventorySlotContents(int slotIndex, ItemStack stack) {
        inventory[slotIndex] = stack;
        onInventoryChanged();
    }

    @Override
    public ItemStack decrStackSize(int slotIndex, int amount) {
        return InventoryUtils.decrStackSize(this, slotIndex, amount);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slotIndex) {
        return InventoryUtils.getStackInSlotOnClosing(this, slotIndex);
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override
    public void openChest() {
    }

    @Override
    public void closeChest() {
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        InventoryUtils.readStacksFromNBT(inventory, tagCompound.getTagList("Inventory"));
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.setTag("Inventory", InventoryUtils.writeStacksToNBT(inventory));
    }

    @Override
    public String getInvName() {
        return "TileEntityEasyCrafting";
    }

    @Override
    public boolean isInvNameLocalized() {
        return false;
    }

    @Override
    public boolean isItemValidForSlot(int slotIndex, ItemStack itemstack) {
        if (slotIndex >= 40) {
            return true;
        }
        return false;
    }
}