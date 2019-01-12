package com.raden93.veganlife.proxy;


import com.raden93.veganlife.VeganLifeMod;
import com.raden93.veganlife.block.jute.BaleOfJuteColorHandler;
import com.raden93.veganlife.init.VeganLifeBlocks;
import com.raden93.veganlife.init.VeganLifeModels;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);
		
		MinecraftForge.EVENT_BUS.register(VeganLifeModels.class);
	}

	public void init(FMLInitializationEvent event) {
		super.init(event);
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(new BaleOfJuteColorHandler(), VeganLifeBlocks.bale_of_jute_block);
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(new BaleOfJuteColorHandler(), VeganLifeBlocks.bale_of_jute_block);
	}

	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
		
		
	}
}
