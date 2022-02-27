package net.endplex.plexmod.item.custom;

import net.endplex.plexmod.item.ModItems;
import net.endplex.plexmod.item.entity.GrenadeEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BananaSwordItem extends SwordItem {

    public BananaSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        GrenadeEntity grenadeEntity = new GrenadeEntity(world, user);

        grenadeEntity.setItem(ModItems.POOP.getDefaultStack());
        grenadeEntity.setProperties(user, user.getPitch(), user.getYaw(), 100.0F, 1.5F, 1.0F);
        world.spawnEntity(grenadeEntity);

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.plexmod.banana_sword"));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
