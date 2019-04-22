package timaxa007.very_custom_armor.client.armor;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import timaxa007.very_custom_armor.client.ArmorCustomModel;
import timaxa007.very_custom_armor.client.EventsClient;

@SideOnly(Side.CLIENT)
public class ArmorWaterModel extends ArmorCustomModel {

	private final int partType;

	/**armorType: 0 - head, 1 - body and arms, 2 - legs, 3 - feet.**/
	public ArmorWaterModel(int armorType) {
		partType = armorType;
	}

	@Override
	public void pre() {

	}

	@Override
	public void post() {

	}

	@Override
	public void partHead() {
		if (partType == 0) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(EventsClient.texture_wooden);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_water", "mask_frame"));
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_water", "tube"));

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			Minecraft.getMinecraft().renderEngine.bindTexture(EventsClient.texture_glass);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_water", "mask_glass"));

			GL11.glDisable(GL11.GL_BLEND);
		}
	}

	@Override
	public void partBody() {
	}

	@Override
	public void partRightArm() {

	}

	@Override
	public void partLeftArm() {

	}

	@Override
	public void partRightLeg() {
		if (partType == 3) {
			GL11.glTranslatef(0.125F, -0.75F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(EventsClient.texture_wooden);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_water", "flipper_right"));
		}
	}

	@Override
	public void partLeftLeg() {
		if (partType == 3) {
			GL11.glTranslatef(-0.125F, -0.75F, 0F);
			Minecraft.getMinecraft().renderEngine.bindTexture(EventsClient.texture_wooden);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_water", "flipper_left"));
		}
	}

}
