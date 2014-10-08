package alphaitems.dimensions.providers;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import alphaitems.biomes.Biomes;
import alphaitems.dimensions.venus.Venus;
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
		this.worldChunkMgr = new WorldChunkManagerHell(
				Biomes.venus, 8F, 6.0F);
		this.dimensionId = Venus.dimId;
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
		return "DIM-21";
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