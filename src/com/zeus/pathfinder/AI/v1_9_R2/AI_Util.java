package com.zeus.pathfinder.AI.v1_9_R2;

import java.lang.reflect.Field;

import javax.annotation.Nullable;

import org.bukkit.craftbukkit.v1_9_R2.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import com.zeus.pathfinder.AI.AI_Util_Main;
import com.zeus.pathfinder.AI.AIItem.AbstractAIItem;
import com.zeus.pathfinder.AI.v1_9_R2.AI_Util;

import net.minecraft.server.v1_9_R2.PathfinderGoalBreakDoor;
import net.minecraft.server.v1_9_R2.PathfinderGoalFleeSun;
import net.minecraft.server.v1_9_R2.PathfinderGoalOpenDoor;
import net.minecraft.server.v1_9_R2.PathfinderGoalMoveIndoors;
import net.minecraft.server.v1_9_R2.EntityCreature;
import net.minecraft.server.v1_9_R2.EntityInsentient;
import net.minecraft.server.v1_9_R2.EntityLiving;
import net.minecraft.server.v1_9_R2.PathfinderGoal;
import net.minecraft.server.v1_9_R2.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_9_R2.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_9_R2.PathfinderGoalPanic;
import net.minecraft.server.v1_9_R2.PathfinderGoalSelector;
public class AI_Util implements AI_Util_Main
{
	private void KillGoalSelector(EntityInsentient e) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Class<?> cs=Class.forName("net.minecraft.server.v1_9_R2.EntityInsentient");
		Field f=cs.getDeclaredField("goalSelector");
		f.setAccessible(true);
		PathfinderGoalSelector gs=new PathfinderGoalSelector((e.world != null) && (e.world.methodProfiler != null) ? e.world.methodProfiler : null);
		f.set(e,gs);
	}
	private void KillTargetSelector(EntityInsentient e) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Class<?> cs=Class.forName("net.minecraft.server.v1_9_R2.EntityInsentient");
		Field f=cs.getDeclaredField("targetSelector");
		f.setAccessible(true);
		PathfinderGoalSelector gs=new PathfinderGoalSelector((e.world != null) && (e.world.methodProfiler != null) ? e.world.methodProfiler : null);
		f.set(e,gs);
	}
	public Entity getLastDamager(Player le)
	{
		if(le==null || ((CraftPlayer)le).getHandle().getLastDamager()==null)
			return null;
		return ((CraftPlayer)le).getHandle().getLastDamager().getBukkitEntity();
	}
	public Entity getLastDamager(LivingEntity le)
	{
		if(getHandle(le)==null || getHandle(le).getLastDamager()==null)
			return null;
		return getHandle(le).getLastDamager().getBukkitEntity();
	}
	public EntityInsentient getHandle(LivingEntity le)
	{
		if(le==null)
			return null;
		EntityLiving el=((CraftLivingEntity)le).getHandle();
		return (EntityInsentient)el;
	}
	public void KillGoalSelector(LivingEntity e) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		KillGoalSelector(getHandle(e));
	}
	public void KillTargetSelector(LivingEntity e) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		KillTargetSelector(getHandle(e));
	}
	protected PathfinderGoalSelector getGoalSelector(EntityInsentient e)
	{
		return e.goalSelector;
	}
	protected PathfinderGoalSelector getGoalSelector(LivingEntity e)
	{
		return getHandle(e).goalSelector;
	}
	protected PathfinderGoalSelector getTargetSelector(EntityInsentient e)
	{
		return e.targetSelector;
	}
	protected PathfinderGoalSelector getTargetSelector(LivingEntity e)
	{
		return getHandle(e).targetSelector;
	}
	protected void addAItoGoalSelector(EntityInsentient e,PathfinderGoal item,int prop)
	{
		e.goalSelector.a(prop,item);
	}
	protected void addAItoGoalSelector(LivingEntity e,PathfinderGoal item,int prop)
	{
		getHandle(e).goalSelector.a(prop,item);
	}
	protected void addAItoGoalSelector(EntityInsentient e,PathfinderGoal item)
	{
		e.goalSelector.a(item);
	}
	protected void addAItoGoalSelector(LivingEntity e,PathfinderGoal item)
	{
		getHandle(e).goalSelector.a(item);
	}
	protected void addAItoTargetSelector(EntityInsentient e,PathfinderGoal item,int prop)
	{
		e.targetSelector.a(prop,item);
	}
	protected void addAItoTargetSelector(LivingEntity e,PathfinderGoal item,int prop)
	{
		getHandle(e).targetSelector.a(prop,item);
	}
	protected void addAItoTargetSelector(EntityInsentient e,PathfinderGoal item)
	{
		e.targetSelector.a(item);
	}
	protected void addAItoTargetSelector(LivingEntity e,PathfinderGoal item)
	{
		getHandle(e).targetSelector.a(item);
	}
	public void setGoalTarget(LivingEntity e,@Nullable LivingEntity target,TargetReason reason)
	{
		if(target==null)
			getHandle(e).setGoalTarget(null,reason,true);
		else
			getHandle(e).setGoalTarget(((CraftLivingEntity)target).getHandle(),reason,true);
	}
	public Entity getGoalTarget(LivingEntity e)
	{
		if(getHandle(e)==null || getHandle(e).getGoalTarget()==null)
			return null;
		return getHandle(e).getGoalTarget().getBukkitEntity();
	}
	public void addAItoGoalSelector(LivingEntity e, AbstractAIItem item, int prop) 
	{
		if(e==null || item==null)
			return;
		addAItoGoalSelector(e,new PathfinderGoalInterface(item),prop);
	}
	public void addAItoTargetSelector(LivingEntity e, AbstractAIItem item, int prop) 
	{
		if(e==null || item==null)
			return;
		addAItoTargetSelector(e,new PathfinderGoalInterface(item),prop);
	}
	public void addAItoGoalSelector(LivingEntity e, AbstractAIItem item) 
	{
		if(e==null || item==null)
			return;
		addAItoGoalSelector(e,new PathfinderGoalInterface(item));
	}
	public void addAItoTargetSelector(LivingEntity e, AbstractAIItem item) 
	{
		if(e==null || item==null)
			return;
		addAItoTargetSelector(e,new PathfinderGoalInterface(item));
	}
	@Override
	public void addRevengeTargetSelector(LivingEntity e,int prop) 
	{
		PathfinderGoalHurtByTarget goal=new PathfinderGoalHurtByTarget((EntityCreature)getHandle(e), false, (Class<?>[])new Class[0]);
		addAItoTargetSelector(e,goal,prop);
	}
	@Override
	public int getLastDamageTicks(LivingEntity e) 
	{
		return getHandle(e).noDamageTicks;
	}
	@Override
	public int getLastDamageTicks(Player e)
	{
		
		return ((CraftPlayer)e).getHandle().noDamageTicks;
	}
	@Override
	public boolean addMeleeAttackAI(LivingEntity e,double speed,boolean flag,int prop)
	{
		new AI_Util().addAItoGoalSelector(e,new PathfinderGoalMeleeAttack((EntityCreature) new AI_Util().getHandle(e),speed,flag),prop);
		return true;
	}
	@Override
	public boolean addPanicAI(LivingEntity e,double speed,int prop) 
	{
		new AI_Util().addAItoGoalSelector(e,new PathfinderGoalPanic((EntityCreature) new AI_Util().getHandle(e),speed),prop);
		return true;
	}
	@Override
	public boolean addFleeSunAI(LivingEntity e,double speed,int prop) 
	{
		new AI_Util().addAItoGoalSelector(e,new PathfinderGoalFleeSun((EntityCreature) new AI_Util().getHandle(e),speed),prop);
		return true;
	}
	@Override
	public boolean addOpenDoorAI(LivingEntity e,boolean flag,int prop)
	{
		new AI_Util().addAItoGoalSelector(e,new PathfinderGoalOpenDoor((EntityInsentient) new AI_Util().getHandle(e),flag), prop);
		return true;
	}
	@Override
	public boolean addBreakDoorAI(LivingEntity e,int prop) 
	{
		new AI_Util().addAItoGoalSelector(e,new PathfinderGoalBreakDoor((EntityInsentient) new AI_Util().getHandle(e)), prop);
		return true;
	}
	@Override
	public boolean addMoveInDoorAI(LivingEntity e,int prop)
	{
		new AI_Util().addAItoGoalSelector(e,new PathfinderGoalMoveIndoors((EntityCreature) new AI_Util().getHandle(e)),prop);
		return true;
	}
}
