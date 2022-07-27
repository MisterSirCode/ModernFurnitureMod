package net.scmods;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Table extends MostlyEmptyBlock {
    protected final VoxelShape combinedShape = VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(
        VoxelShapes.cuboid(0, 0.875, 0, 1, 1, 1), 
        VoxelShapes.cuboid(0.8125, 0, 0.0625, 0.9375, 0.9375, 0.1875)), 
        VoxelShapes.cuboid(0.8125, 0, 0.8125, 0.9375, 0.9375, 0.9375)), 
        VoxelShapes.cuboid(0.0625, 0, 0.8125, 0.1875, 0.9375, 0.9375)), 
        VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.1875, 0.9375, 0.1875));

    public Table(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return combinedShape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return combinedShape;
    }
}