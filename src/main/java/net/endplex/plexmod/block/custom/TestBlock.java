package net.endplex.plexmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public TestBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(CLICKED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()) {
            if(hand == Hand.MAIN_HAND) {
                boolean currentState = state.get(CLICKED);
                world.setBlockState(pos, state.with(CLICKED, !currentState), Block.NOTIFY_ALL);
            }
        }


        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CLICKED);
    }
}
