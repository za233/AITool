package com.zeus.pathfinder.Manager;

import org.bukkit.entity.LivingEntity;

import com.zeus.pathfinder.Main;

public class ControlManager 
{
	private LivingEntity target;
	public ControlManager(LivingEntity target)
	{
		this.target=target;
	}
	public void doJump()
	{
		Main.nms_control.doJump(this.target);
	}
	public void setJump()
	{
		Main.nms_control.setJump(this.target);
	}
	public void setMoveTo(double x,double y,double z,double speed)
	{
		Main.nms_control.setMoveTo(this.target,x,y,z, speed);
	}
	public void lookTicks(double x,double y,double z)
	{
		Main.nms_control.lookTicks(this.target,x,y,z);
	}
}
