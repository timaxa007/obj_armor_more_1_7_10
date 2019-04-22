package timaxa007.very_custom_armor.client.armor;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import timaxa007.very_custom_armor.client.ArmorCustomModel;
import timaxa007.very_custom_armor.client.EventsClient;

@SideOnly(Side.CLIENT)
public class ArmorPlaneModel extends ArmorCustomModel {

	private final int partType;

	/**armorType: 0 - head, 1 - body and arms, 2 - legs, 3 - feet.**/
	public ArmorPlaneModel(int armorType) {
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
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "helm"));

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			Minecraft.getMinecraft().renderEngine.bindTexture(EventsClient.texture_glass);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "glass"));

			GL11.glDisable(GL11.GL_BLEND);
		}
	}

	@Override
	public void partBody() {
		Minecraft.getMinecraft().renderEngine.bindTexture(EventsClient.texture_wooden);
		if (partType == 1) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "body"));
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "plane"));
		}
	}

	@Override
	public void partRightArm() {
		if (partType == 1) {
			GL11.glTranslatef(0.3125F, -1.375F, 0F);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "right_arm"));
		}
	}

	@Override
	public void partLeftArm() {
		if (partType == 1) {
			GL11.glTranslatef(-0.3125F, -1.375F, 0F);
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "left_arm"));
		}
	}

	@Override
	public void partRightLeg() {
		GL11.glTranslatef(0.125F, -0.75F, 0F);
		if (partType == 2)
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "right_leg"));
		if (partType == 3)
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "right_boot"));
	}

	@Override
	public void partLeftLeg() {
		GL11.glTranslatef(-0.125F, -0.75F, 0F);
		if (partType == 2)
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "left_leg"));
		if (partType == 3)
			GL11.glCallList(EventsClient.getRenderPart("armor/armor_plane", "left_boot"));
	}

}
