package net.sleepykairo.dwarfmod.item.custom;

import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.block.enums.RailShape;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MinecartItem;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import net.sleepykairo.dwarfmod.entity.custom.MithrilMinecartEntity;

public class MithrilMinecartItem extends Item {
    private static final DispenserBehavior DISPENSER_BEHAVIOR = new ItemDispenserBehavior() {
        private final ItemDispenserBehavior defaultBehavior = new ItemDispenserBehavior();

        @Override
        public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
            Direction direction = pointer.state().get(DispenserBlock.FACING);
            ServerWorld serverWorld = pointer.world();
            Vec3d vec3d = pointer.centerPos();
            double d = vec3d.getX() + (double)direction.getOffsetX() * 1.125;
            double e = Math.floor(vec3d.getY()) + (double)direction.getOffsetY();
            double f = vec3d.getZ() + (double)direction.getOffsetZ() * 1.125;
            BlockPos blockPos = pointer.pos().offset(direction);
            BlockState blockState = serverWorld.getBlockState(blockPos);
            RailShape railShape = blockState.getBlock() instanceof AbstractRailBlock
                    ? blockState.get(((AbstractRailBlock)blockState.getBlock()).getShapeProperty())
                    : RailShape.NORTH_SOUTH;
            double g;
            if (blockState.isIn(BlockTags.RAILS)) {
                if (railShape.isAscending()) {
                    g = 0.6;
                } else {
                    g = 0.1;
                }
            } else {
                if (!blockState.isAir() || !serverWorld.getBlockState(blockPos.down()).isIn(BlockTags.RAILS)) {
                    return this.defaultBehavior.dispense(pointer, stack);
                }

                BlockState blockState2 = serverWorld.getBlockState(blockPos.down());
                RailShape railShape2 = blockState2.getBlock() instanceof AbstractRailBlock
                        ? blockState2.get(((AbstractRailBlock)blockState2.getBlock()).getShapeProperty())
                        : RailShape.NORTH_SOUTH;
                if (direction != Direction.DOWN && railShape2.isAscending()) {
                    g = -0.4;
                } else {
                    g = -0.9;
                }
            }

//            MithrilMinecartEntity mithrilMinecartEntity = MithrilMinecartEntity.create(serverWorld, d, e + g, f, stack, null);
            MithrilMinecartEntity mithrilMinecartEntity = new MithrilMinecartEntity(serverWorld, d, e + g, f);
            serverWorld.spawnEntity(mithrilMinecartEntity);

            stack.decrement(1);
            return stack;
        }

        @Override
        protected void playSound(BlockPointer pointer) {
            pointer.world().syncWorldEvent(WorldEvents.DISPENSER_DISPENSES, pointer.pos(), 0);
        }
    };
    final AbstractMinecartEntity.Type type;

    public MithrilMinecartItem(AbstractMinecartEntity.Type type, Item.Settings settings) {
        super(settings);
        this.type = type;
        DispenserBlock.registerBehavior(this, DISPENSER_BEHAVIOR);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        if (!blockState.isIn(BlockTags.RAILS)) {
            return ActionResult.FAIL;
        } else {
            ItemStack itemStack = context.getStack();
            if (world instanceof ServerWorld serverWorld) {
                RailShape railShape = blockState.getBlock() instanceof AbstractRailBlock
                        ? blockState.get(((AbstractRailBlock)blockState.getBlock()).getShapeProperty())
                        : RailShape.NORTH_SOUTH;
                double d = 0.0;
                if (railShape.isAscending()) {
                    d = 0.5;
                }

//                MithrilMinecartEntity mithrilMinecartEntity = new MithrilMinecartEntity(
//                        serverWorld, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.0625 + d, (double)blockPos.getZ() + 0.5
//                );
                MithrilMinecartEntity mithrilMinecartEntity = new MithrilMinecartEntity(serverWorld, (double)blockPos.getX() + 0.5, (double)blockPos.getY() + 0.0625 + d, (double)blockPos.getZ() + 0.5);
                serverWorld.spawnEntity(mithrilMinecartEntity);
                serverWorld.emitGameEvent(GameEvent.ENTITY_PLACE, blockPos, GameEvent.Emitter.of(context.getPlayer(), serverWorld.getBlockState(blockPos.down())));
            }

            itemStack.decrement(1);
            return ActionResult.success(world.isClient);
        }
    }
}
