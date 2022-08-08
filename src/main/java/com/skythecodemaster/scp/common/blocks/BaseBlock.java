package com.skythecodemaster.scp.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class BaseBlock extends Block {
  private final TagKey<Block> harvestTag;
  
  public BaseBlock() {
    this(BlockTags.NEEDS_IRON_TOOL);
  }
  
  public BaseBlock(TagKey<Block> harvestTag) {
    this(
      Properties.of(Material.HEAVY_METAL)
        .strength( 1,5)
        .sound(SoundType.METAL)
        .noOcclusion()
        .requiresCorrectToolForDrops(),
      harvestTag
    );
  }
  
  public BaseBlock(Properties properties) {
    this(
      properties,
      BlockTags.NEEDS_IRON_TOOL
    );
  }
  
  public BaseBlock(Properties properties, TagKey<Block> harvestTag) {
    super(properties);
    this.harvestTag = harvestTag;
  }
  
  @NotNull
  @Override
  public InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hit) {
    
    return InteractionResult.SUCCESS;
  }
  
  public TagKey<Block> getHarvestTag() {
    return harvestTag;
  }
}
