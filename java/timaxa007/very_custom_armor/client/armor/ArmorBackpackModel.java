package timaxa007.very_custom_armor.client.armor;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import timaxa007.very_custom_armor.client.ArmorCustomModel;
import timaxa007.very_custom_armor.client.EventsClient;

@SideOnly(Side.CLIENT)
public class ArmorBackpackModel extends ArmorCustomModel {

	private final int partType;

	/**armorType: 0 - head, 1 - body and arms, 2 - legs, 3 - feet.**/
	public ArmorBackpackModel(int armorType) {
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

	}

	@Override
	public void partBody() {
		Minecraft.getMinecraft().renderEngine.bindTexture(EventsClient.texture_wooden);
		if (partType == 1) {
			GL11.glTranslatef(0F, -1.5F, 0F);
			GL11.glCallList(EventsClient.getRenderAll("armor/backpack"));
		}
	}

	@Override
	public void partRightArm() {

	}

	@Override
	public void partLeftArm() {

	}

	@Override
	public void partRightLeg() {

	}

	@Override
	public void partLeftLeg() {

	}

}
