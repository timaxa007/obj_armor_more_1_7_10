package timaxa007.very_custom_armor;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;

@Mod(modid = VeryCustomArmorMod.MODID, name = VeryCustomArmorMod.NAME, version = VeryCustomArmorMod.VERSION)
public class VeryCustomArmorMod {

	public static final String
	MODID = "very_custom_armor",
	NAME = "Very Custom Armor Mod",
	VERSION = "0.5.3";

	@Mod.Instance(MODID)
	public static VeryCustomArmorMod instance;

	@SidedProxy(modId = MODID,
			serverSide = "timaxa007.very_custom_armor.ProxyCommon",
			clientSide = "timaxa007.very_custom_armor.client.ProxyClient")
	public static ProxyCommon proxy;

	public static Item

	armor_plane_helmet,
	armor_plane_chestplate,
	armor_plane_pants,
	armor_plane_boots,

	armor_water_helmet,
	armor_water_boots,

	armor_backpack,

	armor_hat,

	armor_mask_filter,

	armor_nimbus

	;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		armor_plane_helmet = new ItemCustomArmor(ArmorMaterial.IRON, 0).setUnlocalizedName("armor_plane_helmet").setTextureName(MODID + ":armor_plane_helmet").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_plane_helmet, "armor_plane_helmet");

		armor_plane_chestplate = new ItemCustomArmor(ArmorMaterial.IRON, 1).setUnlocalizedName("armor_plane_chestplate").setTextureName(MODID + ":armor_plane_chestplate").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_plane_chestplate, "armor_plane_chestplate");

		armor_plane_pants = new ItemCustomArmor(ArmorMaterial.IRON, 2).setUnlocalizedName("armor_plane_pants").setTextureName(MODID + ":armor_plane_pants").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_plane_pants, "armor_plane_pants");

		armor_plane_boots = new ItemCustomArmor(ArmorMaterial.IRON, 3).setUnlocalizedName("armor_plane_boots").setTextureName(MODID + ":armor_plane_boots").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_plane_boots, "armor_plane_boots");


		armor_water_helmet = new ItemCustomArmor(ArmorMaterial.IRON, 0).setUnlocalizedName("armor_water_helmet").setTextureName(MODID + ":armor_water_helmet").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_water_helmet, "armor_water_helmet");

		armor_water_boots = new ItemCustomArmor(ArmorMaterial.IRON, 3).setUnlocalizedName("armor_water_boots").setTextureName(MODID + ":armor_water_boots").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_water_boots, "armor_water_boots");


		armor_backpack = new ItemCustomArmor(ArmorMaterial.IRON, 1).setUnlocalizedName("armor_backpack").setTextureName(MODID + ":armor_backpack").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_backpack, "armor_backpack");


		armor_hat = new ItemCustomArmor(ArmorMaterial.IRON, 0).setUnlocalizedName("armor_hat").setTextureName(MODID + ":armor_hat").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_hat, "armor_hat");


		armor_mask_filter = new ItemCustomArmor(ArmorMaterial.IRON, 0).setUnlocalizedName("armor_mask_filter").setTextureName(MODID + ":armor_mask_filter").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_mask_filter, "armor_mask_filter");


		armor_nimbus = new ItemCustomArmor(ArmorMaterial.IRON, 0).setUnlocalizedName("armor_nimbus").setTextureName(MODID + ":armor_nimbus").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(armor_nimbus, "armor_nimbus");

		proxy.preInit();
	}

}
