package com.raden93.veganlife.init;

import java.util.List;
import java.util.Random;
import com.raden93.veganlife.VeganLifeMod;
import com.raden93.veganlife.item.wool.KapokTuftItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VeganLifeDropChanger {
	
	@SubscribeEvent
	public void onHarvestBlock(HarvestDropsEvent event)
	{
		if(!this.userUseShears(event)) {
			IBlockState state = event.getState();
			Block block = state.getBlock();
			Random random = new Random();
			List<ItemStack> drops = event.getDrops();
			
			this.dropJuteFromFerns(block, state, random, drops);
			this.dropKapokFromJungle(block, state, random, drops);
		}
	}
	
	/**
	 * Fern now drops 1-3 Jute Stalks
	 * @param event
	 */
	private void dropJuteFromFerns(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.DOUBLE_PLANT && state.getValue(BlockDoublePlant.VARIANT) == BlockDoublePlant.EnumPlantType.FERN) {
			drops.add(new ItemStack(VeganLifeItems.jute_stalk_item, random.nextInt(2)+1));
		}
	}
	
	private void dropKapokFromJungle(Block block, IBlockState state, Random random, List<ItemStack> drops) {
		if(block == Blocks.LEAVES && state.getValue(BlockOldLeaf.VARIANT) == BlockPlanks.EnumType.JUNGLE) {
			if(random.nextFloat() < 0.07) {
				drops.add(new ItemStack(VeganLifeItems.kapok_tuft_item, 1));
			}
		}
	}
	
	private boolean userUseShears(HarvestDropsEvent event) { 
		return event.getHarvester() != null
				&& event.getHarvester().getHeldItemMainhand() != null
				&& event.getHarvester().getHeldItemMainhand().getItem() instanceof ItemShears;
	}
}
