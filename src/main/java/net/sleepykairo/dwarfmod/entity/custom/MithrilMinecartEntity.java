package net.sleepykairo.dwarfmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.sleepykairo.dwarfmod.entity.ModEntities;
import net.sleepykairo.dwarfmod.item.ModItems;
import net.sleepykairo.dwarfmod.item.custom.MithrilMinecartItem;
import org.jetbrains.annotations.Nullable;

public class MithrilMinecartEntity extends MinecartEntity {
    public MithrilMinecartEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    public MithrilMinecartEntity(EntityType<? extends Entity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        if (player.shouldCancelInteraction()) {
            return ActionResult.PASS;
        } else if (this.hasPassengers()) {
            return ActionResult.PASS;
        } else if (!this.getWorld().isClient) {
            return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
        } else {
            return ActionResult.SUCCESS;
        }
    }

    @Override
    public void onActivatorRail(int x, int y, int z, boolean powered) {
        if (powered) {
            if (this.hasPassengers()) {
                this.removeAllPassengers();
            }

            if (this.getDamageWobbleTicks() == 0) {
                this.setDamageWobbleSide(-this.getDamageWobbleSide());
                this.setDamageWobbleTicks(10);
                this.setDamageWobbleStrength(50.0F);
                this.scheduleVelocityUpdate();
            }
        }
    }

    @Override
    public Item asItem() {
        return ModItems.MITHRIL_MINECART;
    }
    public static MithrilMinecartEntity create(
            ServerWorld world, double x, double y, double z, ItemStack stack, @Nullable PlayerEntity player
    ) {
        MithrilMinecartEntity mithrilMinecartEntity = new MithrilMinecartEntity(world, x, y, z);
        EntityType.copier(world, stack, player).accept(mithrilMinecartEntity);
        return mithrilMinecartEntity;
    }
    @Override
    public ItemStack getPickBlockStack() {
        return new ItemStack(ModItems.MITHRIL_MINECART);
    }
}
