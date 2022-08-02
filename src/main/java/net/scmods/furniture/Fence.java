package net.scmods.furniture;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.scmods.utilities.MostlyEmptyBlock;

public class Fence extends MostlyEmptyBlock {
    protected final VoxelShape collisionShape = VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.5625, 0.875);
    protected final VoxelShape boundingShape = VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(
                                    VoxelShapes.cuboid(0.125, 0.4375, 0.125, 0.875, 0.5625, 0.875),
                                    VoxelShapes.cuboid(0.6875, 0, 0.1875, 0.8125, 0.4375, 0.3125)),
                            VoxelShapes.cuboid(0.6875, 0, 0.6875, 0.8125, 0.4375, 0.8125)),
                    VoxelShapes.cuboid(0.1875, 0, 0.6875, 0.3125, 0.4375, 0.8125)),
            VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.3125, 0.4375, 0.3125));

    public Fence(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return boundingShape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return collisionShape;
    }
}
