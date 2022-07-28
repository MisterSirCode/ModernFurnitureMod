package net.scmods;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class BoxBlockEntity extends BlockEntity {
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(27, ItemStack.EMPTY);

    public BoxBlockEntity(BlockPos pos, BlockState state) {
        super(MFMUtils.BOX_ENTITY, pos, state);
    }
}
