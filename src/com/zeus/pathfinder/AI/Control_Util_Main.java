package com.zeus.pathfinder.AI;

import org.bukkit.entity.LivingEntity;

public interface Control_Util_Main 
{
	public void lookTicks(LivingEntity target,double x,double y,double z);
	public void setJump(LivingEntity target);
	public void doJump(LivingEntity target);
	public void setMoveTo(LivingEntity target,double x,double y,double z,double speed);
	public void setYaw(LivingEntity target,float yaw);
	public void setPitch(LivingEntity target,float pitch);
	public void setX(LivingEntity target,double x);
	public void setY(LivingEntity target,double y);
	public void setZ(LivingEntity target,double z);
	//public void setData()
}
