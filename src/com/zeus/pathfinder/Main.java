package com.zeus.pathfinder;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.zeus.pathfinder.AI.AI_Util_Main;
import com.zeus.pathfinder.AI.Attribute_Util_Main;
import com.zeus.pathfinder.AI.Control_Util_Main;
import com.zeus.pathfinder.AI.Navigation_Util_Main;


public class Main extends JavaPlugin
{
	static public AI_Util_Main nms_ai;
	static public Navigation_Util_Main nms_nav;
	static public Control_Util_Main nms_control;
	static public Attribute_Util_Main nms_attr;
	static public String versionString;
	static public Plugin getMain()
	{
		return Bukkit.getPluginManager().getPlugin("AITool");
	}
	public void onEnable()
	{
		this.getLogger().info("AIToolﾒﾑｱｻｼﾓﾔﾘ｣｡");
		String version=Bukkit.getServer().getClass().getPackage().getName().replace(".",",").split(",")[3];
		if(version.equalsIgnoreCase("v1_14_R1"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_14_R1.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_14_R1.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_14_R1.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_14_R1.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.14.4.");
		}
		else if(version.equalsIgnoreCase("v1_13_R2"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_13_R2.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_13_R2.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_13_R2.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_13_R2.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.13.2.");
		}
		else if(version.equalsIgnoreCase("v1_12_R1"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_12_R1.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_12_R1.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_12_R1.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_12_R1.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.12.2.");
		}
		else if(version.equalsIgnoreCase("v1_11_R1"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_11_R1.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_11_R1.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_11_R1.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_11_R1.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.11.2.");
		}
		else if(version.equalsIgnoreCase("v1_10_R1"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_10_R1.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_10_R1.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_10_R1.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_10_R1.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.10.1");
		}
		else if(version.equalsIgnoreCase("v1_9_R2"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_9_R2.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_9_R2.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_9_R2.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_9_R2.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.9.");
		}
		else if(version.equalsIgnoreCase("v1_9_R1"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_9_R1.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_9_R1.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_9_R1.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_9_R1.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.9");
		}
		else if(version.equalsIgnoreCase("v1_8_R3"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_8_R3.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_8_R3.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_8_R3.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_8_R3.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.8");
		}
		else if(version.equalsIgnoreCase("v1_8_R2"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_8_R2.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_8_R2.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_8_R2.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_8_R2.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.8.");
		}
		else if(version.equalsIgnoreCase("v1_8_R1"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_8_R1.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_8_R1.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_8_R1.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_8_R1.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.8.");
		}
		else if(version.equalsIgnoreCase("v1_7_R4"))
		{
			nms_ai=new com.zeus.pathfinder.AI.v1_7_R4.AI_Util();
			nms_nav=new com.zeus.pathfinder.AI.v1_7_R4.Navigation_Util();
			nms_control=new com.zeus.pathfinder.AI.v1_7_R4.Control_Util();
			nms_attr=new com.zeus.pathfinder.AI.v1_7_R4.Attribute_Util();
			this.getLogger().info("ｵｱﾇｰﾊﾊﾓﾃｰ豎ｾ:1.7.10.");
		}
		Main.versionString=version;
	}
	public void onDisable()
	{
		this.getLogger().info("AIToolﾒﾑｱｻﾐｶﾔﾘ｣｡");
	}
	public static void debug(String string) 
	{
		Bukkit.getPluginManager().getPlugin("AITool").getLogger().info(string);
	}
}
