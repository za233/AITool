package com.zeus.pathfinder.Manager;

import org.bukkit.entity.LivingEntity;

import com.zeus.pathfinder.Main;

public class NavigationManager 
{
	private LivingEntity target;
	public NavigationManager(LivingEntity le)
	{
		this.target=le;
	}
	public boolean navigationTo(double x,double y,double z,double speed)
	{
		return Main.nms_nav.navigationTo(this.target, x, y, z, speed);
	}
	public boolean navigationTo(LivingEntity le,double speed)
	{
		return Main.nms_nav.navigationTo(target, le, speed);
	}
	public void stop()
	{
		Main.nms_nav.stop(this.target);
	}
	public void ticks()
	{
		Main.nms_nav.ticks(this.target);
	}
	public boolean hasPath()
	{
		return Main.nms_nav.hasPath(this.target);
	}
}
