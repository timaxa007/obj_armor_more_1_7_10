package timaxa007.very_custom_armor.client;

import java.util.HashMap;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.model.AdvancedModelLoader;
import timaxa007.very_custom_armor.VeryCustomArmorMod;
import timaxa007.very_custom_armor.client.armor.ArmorBackpackModel;
import timaxa007.very_custom_armor.client.armor.ArmorHatModel;
import timaxa007.very_custom_armor.client.armor.ArmorMaskFilterModel;
import timaxa007.very_custom_armor.client.armor.ArmorNimbusModel;
import timaxa007.very_custom_armor.client.armor.ArmorPlaneModel;
import timaxa007.very_custom_armor.client.armor.ArmorWaterModel;

public class EventsClient {

	public static final ResourceLocation
	texture_metal = new ResourceLocation(VeryCustomArmorMod.MODID, "textures/metal.png"),
	texture_wooden = new ResourceLocation(VeryCustomArmorMod.MODID, "textures/wooden.png"),
	texture_glass = new ResourceLocation(VeryCustomArmorMod.MODID, "textures/glass.png");

	private static final HashMap<String, Integer> hash = new HashMap<String, Integer>();

	public EventsClient() {

		//if (isCheck) {
		//getRenderPart("armor/armor_plane", "helm");
		//getRenderPart("armor/armor_plane", "glass");
		//getRenderPart("armor/armor_plane", "body");
		//getRenderPart("armor/armor_plane", "plane");
		//getRenderPart("armor/armor_plane", "right_arm");
		//getRenderPart("armor/armor_plane", "left_arm");
		//getRenderPart("armor/armor_plane", "right_leg");
		//getRenderPart("armor/armor_plane", "left_leg");
		//getRenderPart("armor/armor_plane", "right_boot");
		//getRenderPart("armor/armor_plane", "left_boot");

		//getRenderPart("armor/armor_water", "mask_frame");
		//getRenderPart("armor/armor_water", "tube");
		//getRenderPart("armor/armor_water", "mask_glass");
		//getRenderPart("armor/armor_water", "flipper_right");
		//getRenderPart("armor/armor_water", "flipper_left");

		//getRenderAll("armor/backpack");

		//getRenderPart("armor/hat", "coin");
		//getRenderPart("armor/hat", "line");
		//getRenderPart("armor/hat", "hat");

		//getRenderPart("armor/mask_filter", "glass");
		//getRenderPart("armor/mask_filter", "string");
		//getRenderPart("armor/mask_filter", "sheld");
		//getRenderPart("armor/mask_filter", "filter");
		//getRenderPart("armor/mask_filter", "frame");

		//getRenderAll("armor/nimbus");
		//}

	}

	@SubscribeEvent
	public void onRenderArmomForPlayer(RenderPlayerEvent.SetArmorModel event) {
		if (event.stack == null) return;
		ArmorCustomModel acm = getModel(event.entityPlayer, event.stack, event.slot);
		if (acm == null) return;
		acm.partHead.set(event.renderer.modelBipedMain.bipedHead);
		acm.partBody.set(event.renderer.modelBipedMain.bipedBody);
		acm.partRightArm.set(event.renderer.modelBipedMain.bipedRightArm);
		acm.partLeftArm.set(event.renderer.modelBipedMain.bipedLeftArm);
		acm.partRightLeg.set(event.renderer.modelBipedMain.bipedRightLeg);
		acm.partLeftLeg.set(event.renderer.modelBipedMain.bipedLeftLeg);
		acm.render(event.entityPlayer);
	}

	private static final ArmorCustomModel

	armor_plane0 = new ArmorPlaneModel(0),
	armor_plane1 = new ArmorPlaneModel(1),
	armor_plane2 = new ArmorPlaneModel(2),
	armor_plane3 = new ArmorPlaneModel(3),

	armor_water0 = new ArmorWaterModel(0),
	armor_water3 = new ArmorWaterModel(3),

	backpack = new ArmorBackpackModel(1),

	hat = new ArmorHatModel(0),

	mask_filter = new ArmorMaskFilterModel(0),

	nimbus = new ArmorNimbusModel(0);

	private static ArmorCustomModel getModel(EntityLivingBase entityPlayer, ItemStack stack, int slot) {

		if (stack.getItem() == VeryCustomArmorMod.armor_plane_helmet) return armor_plane0;
		else if (stack.getItem() == VeryCustomArmorMod.armor_plane_chestplate) return armor_plane1;
		else if (stack.getItem() == VeryCustomArmorMod.armor_plane_pants) return armor_plane2;
		else if (stack.getItem() == VeryCustomArmorMod.armor_plane_boots) return armor_plane3;

		else if (stack.getItem() == VeryCustomArmorMod.armor_water_helmet) return armor_water0;
		else if (stack.getItem() == VeryCustomArmorMod.armor_water_boots) return armor_water3;

		else if (stack.getItem() == VeryCustomArmorMod.armor_backpack) return backpack;

		else if (stack.getItem() == VeryCustomArmorMod.armor_hat) return hat;

		else if (stack.getItem() == VeryCustomArmorMod.armor_mask_filter) return mask_filter;

		else if (stack.getItem() == VeryCustomArmorMod.armor_nimbus) return nimbus;

		else return null;
	}

	public static int getRenderAll(String model) {
		if (hash.containsKey(model)) return hash.get(model);
		int displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		AdvancedModelLoader.loadModel(new ResourceLocation(VeryCustomArmorMod.MODID, "model/" + model + ".obj")).renderAll();
		GL11.glEndList();
		hash.put(model, displayList);
		return displayList;
	}

	public static int getRenderPart(String model, String partName) {
		if (hash.containsKey(model + "_" + partName)) return hash.get(model + "_" + partName);
		int displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		AdvancedModelLoader.loadModel(new ResourceLocation(VeryCustomArmorMod.MODID, "model/" + model + ".obj")).renderPart(partName);
		GL11.glEndList();
		hash.put(model + "_" + partName, displayList);
		return displayList;
	}

}
