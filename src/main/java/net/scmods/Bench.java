package net.scmods;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class Bench extends Block implements Waterloggable {
    public static final VoxelShape benchShape = VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(VoxelShapes.union(
		VoxelShapes.cuboid(0.125, 0.4375, 0.125, 0.875, 0.5625, 0.875), 
		VoxelShapes.cuboid(0.6875, 0, 0.1875, 0.8125, 0.4375, 0.3125)), 
		VoxelShapes.cuboid(0.6875, 0, 0.6875, 0.8125, 0.4375, 0.8125)), 
		VoxelShapes.cuboid(0.1875, 0, 0.6875, 0.3125, 0.4375, 0.8125)), 
		VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.3125, 0.4375, 0.3125));

    public Bench(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return benchShape;
    }
}