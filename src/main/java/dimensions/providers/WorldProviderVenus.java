package alphaitems.dimensions.providers;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import alphaitems.dimensions.venus.Venus;
import alphaitems.dimensions.venus.WorldChunkManagerVenus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderVenus extends WorldProvider {
	
	public static IRenderHandler skyRenderer = null;
	public static IRenderHandler cloudRenderer = null;
	
	@Override
	public String getDimensionName() {
		return "Venus";
	}
	
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerVenus(this.getSeed(),
				terrainType);
		this.dimensionId = Venus.dimId;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean getWorldHasVoidParticles() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer()
	{
		return this.skyRenderer;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void setSkyRenderer(IRenderHandler skyRenderer)
	{
		this.skyRenderer = skyRenderer;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getCloudRenderer()
	{
		return cloudRenderer;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void setCloudRenderer(IRenderHandler renderer)
	{
		cloudRenderer = renderer;
	}
	
	@Override
	public int getHeight()
	{
		return 256;
	}
	
	@Override
	public float getStarBrightness(float par1) {
		return 8.0F;
	}
	
	protected synchronized String setUserMessage(String par1Str)
	{
		return "Loading Venus";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getCloudHeight()
	{
		return 208.0F;
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