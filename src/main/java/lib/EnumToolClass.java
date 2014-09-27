package alphaitems.lib;

public enum EnumToolClass {
	WOOD(0),
	STONE(1),
	IRON(2),
	DIAMOND(3),
	AMARANTH(4);
	
	private int value;
	private static EnumToolClass INSTANCE;
	
	private EnumToolClass(int toolClass) {
		this.value = toolClass;
	}
	
	private EnumToolClass() {
		this.value = 0;
	}
	
	public static int getToolClassValue(EnumToolClass val) {
		return val.value;
	}
	
	public static EnumToolClass getInstance() {
		return INSTANCE;
	}
}