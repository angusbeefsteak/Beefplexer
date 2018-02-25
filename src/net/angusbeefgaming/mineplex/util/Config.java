package net.angusbeefgaming.mineplex.util;

public class Config {
	
	private static boolean adminBlockBreak;
	
	public static boolean canAdminBreakBlock() {
		return adminBlockBreak;
	}
	public static void setAdminBreakBlock(boolean a) {
		adminBlockBreak = a;
	}

}
