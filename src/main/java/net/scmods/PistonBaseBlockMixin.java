package net.scmods;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EndPortalFrameBlock;
import net.minecraft.world.level.block.piston.PistonBaseBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PistonBaseBlock.class)
public class PistonBaseBlockMixin {
    @Inject(method = "isPushable", at = @At(value = "INVOKE", shift = At.Shift.BEFORE, target = "Lnet/minecraft/world/level/block/state/BlockState;getDestroySpeed(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F"), cancellable = true)
    private static void modifyMovable(BlockState state, Level world, BlockPos pos, Direction direction, boolean canBreak, Direction pistonDir, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(Box)) {
            cir.setReturnValue(true);
        }
    }
}
