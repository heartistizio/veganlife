package com.raden93.veganlife.init;

import com.raden93.veganlife.VeganLifeConstants;
import com.raden93.veganlife.item.jute.BurlapItem;
import com.raden93.veganlife.item.jute.JuteFibreItem;
import com.raden93.veganlife.item.jute.JuteSeedsItem;
import com.raden93.veganlife.item.jute.JuteStalkItem;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class VeganLifeItems {
	
public static final JuteStalkItem jute_stalk_item = new JuteStalkItem();
public static final JuteFibreItem jute_fibre_item = new JuteFibreItem();
public static final JuteSeedsItem jute_seeds_item = new JuteSeedsItem();
public static final BurlapItem burlap_item = new BurlapItem();
	
	public static void init() {
		setName(jute_stalk_item, "jutestalk");
		setName(jute_fibre_item, "jutefibre");
		setName(jute_seeds_item, "juteseeds");
		setName(burlap_item, "burlap");
	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(jute_stalk_item);
		registry.register(jute_fibre_item);
		registry.register(jute_seeds_item);
		registry.register(burlap_item);
	}
	
	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(VeganLifeConstants.MODID, name));
		item.setUnlocalizedName(name);
	}
}
