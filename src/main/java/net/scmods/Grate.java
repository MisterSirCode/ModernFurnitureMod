package net.scmods;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Grate extends MostlyEmptyBlock {
    protected final VoxelShape collisionShape = VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(
        VoxelShapes.cuboid(0.875, 0, 0, 1, 1, 0.875), 
        VoxelShapes.cuboid(0.125, 0, 0.875, 1, 1, 1)), 
        VoxelShapes.cuboid(0, 0, 0.125, 0.125, 1, 1)), 
        VoxelShapes.cuboid(0, 0, 0, 0.875, 1, 0.125));
    protected final VoxelShape boundingShape = VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(
		VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(
		VoxelShapes.union(VoxelShapes.cuboid(-0.125, 0.8125, 0.0625, 0.875, 0.9375, 0.1875), 
		VoxelShapes.cuboid(0.8125, 0.8125, -0.125, 0.9375, 0.9375, 0.875)), 
		VoxelShapes.cuboid(0.0625, 0.4375, 0.8125, 1.0625, 0.5625, 0.9375)), 
		VoxelShapes.cuboid(0.0625, 0.4375, 0.0625, 0.1875, 0.5625, 1.0625)), 
		VoxelShapes.cuboid(-0.125, 0.3125, 0.0625, 0.875, 0.4375, 0.1875)), 
		VoxelShapes.cuboid(0.8125, 0.3125, -0.125, 0.9375, 0.4375, 0.875)), 
		VoxelShapes.cuboid(0.0625, -0.0625, 0.8125, 1.0625, 0.0625, 0.9375)), 
		VoxelShapes.cuboid(0.0625, -0.0625, 0.0625, 0.1875, 0.0625, 1.0625)), 
		VoxelShapes.cuboid(0.875, 0, 0.875, 1, 1, 1)), 
		VoxelShapes.cuboid(0, 0, 0.875, 0.125, 1, 1)), 
		VoxelShapes.cuboid(0, 0, 0, 0.125, 1, 0.125)), 
		VoxelShapes.cuboid(0.875, 0, 0, 1, 1, 0.125));

    public Grate(Settings settings) {
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