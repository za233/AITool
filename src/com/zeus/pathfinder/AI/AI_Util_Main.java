package com.zeus.pathfinder.AI;


import javax.annotation.Nullable;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import com.zeus.pathfinder.AI.AIItem.AbstractAIItem;

public interface AI_Util_Main 
{
	public Entity getLastDamager(Player le);
	public Entity getLastDamager(LivingEntity le);
	public void KillGoalSelector(LivingEntity e) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	public void KillTargetSelector(LivingEntity e) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	public void addAItoGoalSelector(LivingEntity e,AbstractAIItem item,int prop);
	public void addAItoTargetSelector(LivingEntity e,AbstractAIItem item,int prop);
	public void addAItoGoalSelector(LivingEntity e,AbstractAIItem item);
	public void addAItoTargetSelector(LivingEntity e,AbstractAIItem item);
	public void addRevengeTargetSelector(LivingEntity e,int prop);
	public void setGoalTarget(LivingEntity e,@Nullable LivingEntity target,TargetReason reason);
	public Entity getGoalTarget(LivingEntity e);
	public int getLastDamageTicks(LivingEntity e);
	public int getLastDamageTicks(Player e);
	public boolean addMeleeAttackAI(LivingEntity e,double speed,boolean flag,int prop);
	public boolean addPanicAI(LivingEntity e,double speed,int prop);
	public boolean addFleeSunAI(LivingEntity e,double speed,int prop);   
	public boolean addOpenDoorAI(LivingEntity e,boolean flag,int prop);   
	public boolean addBreakDoorAI(LivingEntity e,int prop);
	public boolean addMoveInDoorAI(LivingEntity e,int prop);
	
}
