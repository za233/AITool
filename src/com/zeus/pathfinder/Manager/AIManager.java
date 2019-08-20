package com.zeus.pathfinder.Manager;

import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import com.zeus.pathfinder.Main;
import com.zeus.pathfinder.AI.AIItem.AbstractAIItem;



public class AIManager 
{
	final private LivingEntity targetEntity; 
	public AIManager(LivingEntity le)
	{
		this.targetEntity=le;
	}
	public LivingEntity getTarget()
	{
		return this.targetEntity;
	}
	public void killAttackAI() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Main.nms_ai.KillTargetSelector(this.targetEntity);
	}
	public void killAI() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Main.nms_ai.KillGoalSelector(this.targetEntity);
	}
	public void setAI(List<AbstractAIItem> list) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		for(AbstractAIItem p:list)
			Main.nms_ai.addAItoGoalSelector(this.targetEntity,p);	
	}
	public void setTargetAI(List<AbstractAIItem> list) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		for(AbstractAIItem p:list)
			Main.nms_ai.addAItoTargetSelector(this.targetEntity,p);
	}
	public void addAI(AbstractAIItem item,int prop)
	{
		Main.nms_ai.addAItoGoalSelector(this.targetEntity,item, prop);
	}
	public void addTargetAI(AbstractAIItem item,int prop)
	{
		Main.nms_ai.addAItoTargetSelector(this.targetEntity,item, prop);
	}
	public void setAI(boolean b)
	{
		this.targetEntity.setAI(b);
	}
	public void setGoalTarget(@Nullable LivingEntity e)
	{
		Main.nms_ai.setGoalTarget(this.targetEntity,e,TargetReason.CUSTOM);
	}
	public void setGoalTarget(@Nullable LivingEntity e,TargetReason reason)
	{
		Main.nms_ai.setGoalTarget(this.targetEntity,e,reason);
	}
	public Entity getGoalTarget()
	{
		return Main.nms_ai.getGoalTarget(this.targetEntity);
	}
	public void addRevengeTargetSelector(int prop)
	{
		Main.nms_ai.addRevengeTargetSelector(this.targetEntity,prop);
	}
	public int getLastDamageTicks()
	{
		return Main.nms_ai.getLastDamageTicks(this.targetEntity);
	}
}
