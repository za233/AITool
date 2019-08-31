package com.zeus.pathfinder.AI.v1_8_R2;

import org.bukkit.entity.LivingEntity;

import com.zeus.pathfinder.AI.Navigation_Util_Main;


public class Navigation_Util implements Navigation_Util_Main
{

	@Override
	public boolean navigationTo(LivingEntity target, double x, double y, double z, double speed) 
	{
		return new AI_Util().getHandle(target).getNavigation().a(x, y, z, speed);
	}

	@Override
	public boolean navigationTo(LivingEntity target, LivingEntity le, double speed) 
	{
		return new AI_Util().getHandle(target).getNavigation().a(new AI_Util().getHandle(le), speed);
	}

	@Override
	public void stop(LivingEntity target) 
	{
		new AI_Util().getHandle(target).getNavigation().n();
	}

	@Override
	public void ticks(LivingEntity target)
	{
		new AI_Util().getHandle(target).getNavigation().k();
	}

	@Override
	public boolean noPath(LivingEntity target) 
	{
		return new AI_Util().getHandle(target).getNavigation().m();
	}
	@Override
	public boolean tryNavigationTo(LivingEntity target, double x, double y, double z, double speed) 
	{
		this.navigationTo(target, x, y, z, speed);
		return this.noPath(target);
	}
	
}
