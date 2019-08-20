package com.zeus.pathfinder.Entity;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import com.zeus.pathfinder.AI.AIItem.Special.AttackTargetSelectorAIItem;
import com.zeus.pathfinder.AI.AIItem.Special.FollowTargetAIItem;
import com.zeus.pathfinder.AI.AIItem.Special.MoveTargetLocationAIItem;
import com.zeus.pathfinder.AI.AIItem.Special.WatchTargetAIItem;
import com.zeus.pathfinder.Entity.Interface.AIEdit;
import com.zeus.pathfinder.Entity.Interface.AttackTarget;
import com.zeus.pathfinder.Entity.Interface.FollowTarget;
import com.zeus.pathfinder.Entity.Interface.MoveTarget;
import com.zeus.pathfinder.Entity.Interface.WatchTarget;
import com.zeus.pathfinder.Manager.AIManager;
import com.zeus.pathfinder.Manager.AttributeManager;
import com.zeus.pathfinder.Manager.ControlManager;
import com.zeus.pathfinder.Manager.NavigationManager;



public class MyEntity extends MyEntityAbstract implements AIEdit,MoveTarget,AttackTarget,WatchTarget,FollowTarget
{
	private LivingEntity entity=null,target=null,followTarget=null;
	private boolean isSpawned=false;
	private EntityType type;
	private Location location;
	private Vector targetLocationVector=null,watchLocationVector=null;
	private double moveSpeedToTarget=1.0;
	public EntityType getType()
	{
		return this.type;
	}
	public MyEntity(EntityType e,Location loc) 
	{
		this.type=e;
		this.location=loc;
	}
	public void openKeepAttackTargetFunction(int prop) 
	{
		this.getAIManager().addAI(new AttackTargetSelectorAIItem(this),prop);
		
	}
	public void openTargetLocationFunction(int prop)
	{
		this.getAIManager().addAI(new MoveTargetLocationAIItem(this),prop);
	}
	public void openKeepWatchTargetFunction(int prop) 
	{
		this.getAIManager().addAI(new WatchTargetAIItem(this),prop);
	}
	public void openKeepFollowTargetFunction(int prop)
	{
		this.getAIManager().addAI(new FollowTargetAIItem(this,moveSpeedToTarget),prop);
	}
	public LivingEntity getBukkitEntity() 
	{
		if(isSpawned)
			return this.entity;
		return null;
	}
	public ControlManager getControlHelper()
	{
		if(this.entity==null) return null;
		return new ControlManager(this.entity);
	}
	public NavigationManager getNavigation()
	{
		if(this.entity==null) return null;
		return new NavigationManager(this.entity);
	}
	public AttributeManager getAttributeManager()
	{
		if(this.entity==null) return null;
		return new AttributeManager(this.entity);
	}
	public void AIEdit() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{}
	public void spawnEntity() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException 
	{
		this.isSpawned=true;
		this.entity=(LivingEntity)this.location.getWorld().spawnEntity(this.location,this.type);
		AIEdit();
		this.openTargetLocationFunction(0);
		this.openKeepAttackTargetFunction(0);
		this.openKeepWatchTargetFunction(0);
		this.openKeepFollowTargetFunction(0);
	}
	public boolean isSpawned() 
	{
		return this.isSpawned;
	}
	public void removeAttackAI() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException 
	{
		AIManager editAiManager=new AIManager(this.entity);
		editAiManager.killAttackAI();
	}
	public AIManager getAIManager() 
	{
		if(this.entity==null) return null;
		return new AIManager(this.entity);
	}

	public Vector getTargetLocation()
	{
		return this.targetLocationVector;
	}
	public void setTargetLocation(Vector s) 
	{
		this.targetLocationVector=s;
	}

	public double getSpeedToLocation() 
	{
		return this.moveSpeedToTarget;
	}

	public void setSpeedToLocation(double s) 
	{
		this.moveSpeedToTarget=s;
	}
	public LivingEntity getTarget() 
	{
		return this.target;
	}
	public void setTarget(LivingEntity s) 
	{
		this.target=s;
	}
	public boolean hasTarget()
	{
		return this.target!=null;
	}
	public boolean hasTargetLocation()
	{
		return this.targetLocationVector!=null;
	}
	@Override
	public Vector getWatchTarget() 
	{
		return this.watchLocationVector;
	}
	@Override
	public boolean hasWatchTarget() 
	{
		return this.watchLocationVector!=null;
	}
	@Override
	public void setWatchTarget(Vector s) 
	{
		this.watchLocationVector=s;
	}
	@Override
	public LivingEntity getFollowTarget() 
	{
		return this.followTarget;
	}
	@Override
	public boolean hasFollowTarget() 
	{
		return this.followTarget!=null;
	}
	@Override
	public void setFollowTarget(LivingEntity s)
	{
		this.followTarget=s;
	}
	

}
