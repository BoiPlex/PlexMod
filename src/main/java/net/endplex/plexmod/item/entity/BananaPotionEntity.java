//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.endplex.plexmod.item.entity;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import net.endplex.plexmod.item.ModItems;
import net.minecraft.block.AbstractCandleBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.AxolotlEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Type;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BananaPotionEntity extends ThrownItemEntity implements FlyingItemEntity {
    public static final double field_30667 = 4.0D;
    private static final double field_30668 = 16.0D;
    public static final Predicate<LivingEntity> WATER_HURTS = LivingEntity::hurtByWater;

    public BananaPotionEntity(EntityType<? extends PotionEntity> entityType, World world) {
        super(entityType, world);
    }

    public BananaPotionEntity(World world, LivingEntity owner) {
        super(EntityType.POTION, owner, world);
    }

    public BananaPotionEntity(World world, double x, double y, double z) {
        super(EntityType.POTION, x, y, z, world);
    }

    protected Item getDefaultItem() {
        return Items.SPLASH_POTION;
    }

    protected float getGravity() {
        return 0.05F;
    }

    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        if (!this.world.isClient) {
            ItemStack itemStack = this.getStack();
            Potion potion = PotionUtil.getPotion(itemStack);
            List<StatusEffectInstance> list = PotionUtil.getPotionEffects(itemStack);
            boolean bl = potion == Potions.WATER && list.isEmpty();
            Direction direction = blockHitResult.getSide();
            BlockPos blockPos = blockHitResult.getBlockPos();
            BlockPos blockPos2 = blockPos.offset(direction);
            if (bl) {
                this.extinguishFire(blockPos2);
                this.extinguishFire(blockPos2.offset(direction.getOpposite()));
                Iterator var9 = Type.HORIZONTAL.iterator();

                while(var9.hasNext()) {
                    Direction direction2 = (Direction)var9.next();
                    this.extinguishFire(blockPos2.offset(direction2));
                }
            }

        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            ItemStack itemStack = this.getStack();
            Potion potion = PotionUtil.getPotion(itemStack);
            List<StatusEffectInstance> list = PotionUtil.getPotionEffects(itemStack);
            boolean bl = potion == Potions.WATER && list.isEmpty();
            if (bl) {
                this.damageEntitiesHurtByWater();
            } else if (!list.isEmpty()) {
                if (this.isLingering()) {
                    this.applyLingeringPotion(itemStack, potion);
                } else {
                    this.applySplashPotion(list, hitResult.getType() == net.minecraft.util.hit.HitResult.Type.ENTITY ? ((EntityHitResult)hitResult).getEntity() : null);
                }
            }

            int i = potion.hasInstantEffect() ? 2007 : 2002;
            this.world.syncWorldEvent(i, this.getBlockPos(), PotionUtil.getColor(itemStack));
            this.discard();
        }
    }

    private void damageEntitiesHurtByWater() {
        Box box = this.getBoundingBox().expand(4.0D, 2.0D, 4.0D);
        List<LivingEntity> list = this.world.getEntitiesByClass(LivingEntity.class, box, WATER_HURTS);
        if (!list.isEmpty()) {
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                LivingEntity livingEntity = (LivingEntity)var3.next();
                double d = this.squaredDistanceTo(livingEntity);
                if (d < 16.0D && livingEntity.hurtByWater()) {
                    livingEntity.damage(DamageSource.magic(livingEntity, this.getOwner()), 1.0F);
                }
            }
        }

        List<AxolotlEntity> list2 = this.world.getNonSpectatingEntities(AxolotlEntity.class, box);
        Iterator var8 = list2.iterator();

        while(var8.hasNext()) {
            AxolotlEntity axolotlEntity = (AxolotlEntity)var8.next();
            axolotlEntity.hydrateFromPotion();
        }

    }

    private void applySplashPotion(List<StatusEffectInstance> statusEffects, @Nullable Entity entity) {
        Box box = this.getBoundingBox().expand(4.0D, 2.0D, 4.0D);
        List<LivingEntity> list = this.world.getNonSpectatingEntities(LivingEntity.class, box);
        if (!list.isEmpty()) {
            Entity entity2 = this.getEffectCause();
            Iterator var6 = list.iterator();

            while(true) {
                LivingEntity livingEntity;
                double d;
                do {
                    do {
                        if (!var6.hasNext()) {
                            return;
                        }

                        livingEntity = (LivingEntity)var6.next();
                    } while(!livingEntity.isAffectedBySplashPotions());

                    d = this.squaredDistanceTo(livingEntity);
                } while(!(d < 16.0D));

                double e = 1.0D - Math.sqrt(d) / 4.0D;
                if (livingEntity == entity) {
                    e = 1.0D;
                }

                Iterator var12 = statusEffects.iterator();

                while(var12.hasNext()) {
                    StatusEffectInstance statusEffectInstance1 = new StatusEffectInstance(StatusEffects.ABSORPTION, 600, 2);
                    StatusEffect statusEffect1 = statusEffectInstance1.getEffectType();
                    StatusEffectInstance statusEffectInstance2 = new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 0);
                    StatusEffect statusEffect2 = statusEffectInstance1.getEffectType();

                    int i = (int)(e * (double)statusEffectInstance1.getDuration() + 0.5D);
                    if (i > 20) {
                        livingEntity.addStatusEffect(new StatusEffectInstance(statusEffect1, i, statusEffectInstance1.getAmplifier(), statusEffectInstance1.isAmbient(), statusEffectInstance1.shouldShowParticles()), entity2);
                        livingEntity.addStatusEffect(new StatusEffectInstance(statusEffect2, i, statusEffectInstance2.getAmplifier(), statusEffectInstance2.isAmbient(), statusEffectInstance2.shouldShowParticles()), entity2);
                    }
                }
            }
        }
    }

    private void applyLingeringPotion(ItemStack stack, Potion potion) {
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.world, this.getX(), this.getY(), this.getZ());
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            areaEffectCloudEntity.setOwner((LivingEntity)entity);
        }

        areaEffectCloudEntity.setRadius(3.0F);
        areaEffectCloudEntity.setRadiusOnUse(-0.5F);
        areaEffectCloudEntity.setWaitTime(10);
        areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
        areaEffectCloudEntity.setPotion(potion);
        Iterator var5 = PotionUtil.getCustomPotionEffects(stack).iterator();

        while(var5.hasNext()) {
            StatusEffectInstance statusEffectInstance = (StatusEffectInstance)var5.next();
            areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffectInstance));
        }

        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound != null && nbtCompound.contains("CustomPotionColor", 99)) {
            areaEffectCloudEntity.setColor(nbtCompound.getInt("CustomPotionColor"));
        }

        this.world.spawnEntity(areaEffectCloudEntity);
    }

    private boolean isLingering() {
        return this.getStack().isOf(ModItems.BANANA_LINGERING_POTION);
    }

    private void extinguishFire(BlockPos pos) {
        BlockState blockState = this.world.getBlockState(pos);
        if (blockState.isIn(BlockTags.FIRE)) {
            this.world.removeBlock(pos, false);
        } else if (AbstractCandleBlock.isLitCandle(blockState)) {
            AbstractCandleBlock.extinguish((PlayerEntity)null, blockState, this.world, pos);
        } else if (CampfireBlock.isLitCampfire(blockState)) {
            this.world.syncWorldEvent((PlayerEntity)null, 1009, pos, 0);
            CampfireBlock.extinguish(this.getOwner(), this.world, pos, blockState);
            this.world.setBlockState(pos, (BlockState)blockState.with(CampfireBlock.LIT, false));
        }

    }
}
