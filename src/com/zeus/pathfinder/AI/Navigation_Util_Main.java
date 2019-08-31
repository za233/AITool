package com.zeus.pathfinder.AI;

import org.bukkit.entity.LivingEntity;


public interface Navigation_Util_Main 
{
	public boolean navigationTo(LivingEntity target,double x,double y,double z,double speed);
	public boolean navigationTo(LivingEntity target,LivingEntity le,double speed);
	public void stop(LivingEntity target);
	public void ticks(LivingEntity target);
	public boolean noPath(LivingEntity target);
	public boolean tryNavigationTo(LivingEntity target,double x,double y,double z,double speed);
}
