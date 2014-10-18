package alphaitems.dimensions.providers;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import alphaitems.dimensions.venus.Venus;
import alphaitems.dimensions.venus.WorldChunkManagerVenus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderVenus extends WorldProvider {
	
	@Override
	public String getDimensionName() {
		return "Venus";
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		// this.worldChunkMgr = new WorldChunkManagerHell(
		// Biomes.venus, 8F, 6.0F);
		this.worldChunkMgr = new WorldChunkManagerVenus(this.getSeed(),
				terrainType);
		this.dimensionId = Venus.dimId;
	}
	
	@Override
	public float getStarBrightness(float par1) {
		return 4.0F;
	}
	
	protected synchronized String setUserMessage(String par1Str)
	{
		return "Loading Venus";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight()
	{
		return 128.0F;
	}
	
	@Override
	protected void generateLightBrightnessTable()
	{
		float f = 12.0F;
		for (int i = 0; i <= 15; i++)
		{
			float f1 = 12.0F - i / 15.0F;
			this.lightBrightnessTable[i] = ((1.0F - f1)
					/ (f1 * 3.0F + 1.0F) * (1.0F - f) + f);
		}
	}
	
	public int getSkyColorByTemp(float f) {
		return 0xff7011;
	}
	
	@Override
	public String getWelcomeMessage()
	{
		return "Entering Venus..";
	}
	
	@Override
	public String getDepartMessage() {
		return "Leaving Venus..";
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return false;
	}
	
	@Override
	public String getSaveFolder() {
		return this.getDimensionName();
	}
	
	@Override
	public boolean canRespawnHere() {
		return true;
	}
	
	@Override
	public Vec3 getFogColor(float f, float f1) {
		float f2 = MathHelper.cos(1.4F) * 2.0F + 0.5F;
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		float f3 = 4.0F;
		float f4 = 2.0F;
		float f5 = 0.0F;
		f3 *= f2 * 0.94F + 0.09F;
		f4 *= f2 * 0.94F + 0.00F;
		f5 *= f2 * 0.91F + 0.09F;
		return Vec3.createVectorHelper(f3, f4, f5);
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	@SideOnly(Side.SERVER)
	public IChunkProvider createChunkGenerator()
	{
		return new ChunkProviderVenus(worldObj, worldObj.getSeed(), true);
	}
}