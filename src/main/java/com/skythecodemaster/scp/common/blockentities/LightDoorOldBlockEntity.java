package com.skythecodemaster.scp.common.blockentities;

import com.mojang.logging.LogUtils;
import com.skythecodemaster.scp.common.blocks.LightDoorOld;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static com.skythecodemaster.scp.common.setup.BlockEntityTypes.LIGHT_DOOR_OLD_TILE;

public class LightDoorOldBlockEntity extends BlockEntity implements IAnimatable, BlockEntityTicker<LightDoorOldBlockEntity> {
  public LightDoorOld attachedDoor;
  private static final Logger LOGGER = LogUtils.getLogger(); // Collect a logger
  
  public LightDoorOldBlockEntity(BlockPos pos, BlockState state) {
    super(LIGHT_DOOR_OLD_TILE.get(),pos,state);
  }
  
  private AnimationFactory factory = new AnimationFactory(this);
  private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
    event.getController().setAnimation(new AnimationBuilder().addAnimation("LDO.anim.open"));
    return PlayState.CONTINUE;
  }
  
  @Override
  public void registerControllers(AnimationData data) {
    data.addAnimationController(new AnimationController<LightDoorOldBlockEntity>(this,"controller",60,this::predicate));
  }
  
  @Override
  public AnimationFactory getFactory() {
    return this.factory;
  }
  
  public static void tick(Level level, BlockPos pos, BlockState state, LightDoorOldBlockEntity blockEntity) {
    LOGGER.info("tick called");
    LOGGER.info(String.valueOf(level.hasNeighborSignal(pos)));
    if (level.hasNeighborSignal(pos) || level.hasNeighborSignal(pos.above())) {
      this.attachedDoor.state = true;
    } else {
      this.attachedDoor.state = false;
    }
    this.attachedDoor.doState();
  }
}
