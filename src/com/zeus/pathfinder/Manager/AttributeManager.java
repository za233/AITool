package com.zeus.pathfinder.Manager;

import org.bukkit.entity.LivingEntity;

import com.zeus.pathfinder.Main;

public class AttributeManager 
{
	private LivingEntity targetEntity;
	public AttributeManager(LivingEntity le)
	{
		this.targetEntity=le;
	}
	public void setMaxHealth(double val)
	{
		Main.nms_attr.setMaxHealth(this.targetEntity, val);
	}
	public void setAttackDamage(double val)
	{
		Main.nms_attr.setAttackDamage(this.targetEntity, val);
	}
	public void setFollowRange(double val)
	{
		Main.nms_attr.setFollowRange(this.targetEntity, val);
	}
	public void setKnockBackResistance(double val)
	{
		Main.nms_attr.setKnockBackResistance(this.targetEntity, val);
	}
	public void setSpeed(double val)
	{
		Main.nms_attr.setSpeed(this.targetEntity, val);
	}
}
