package net.endplex.plexmod.block.custom;

import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.endplex.plexmod.item.ModItems;

public class PepperPlantBlock extends CropBlock {
    public PepperPlantBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.PEPPER_SEEDS;
    }
}
