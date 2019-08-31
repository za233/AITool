package com.zeus.pathfinder.AI.AIItem;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import com.zeus.pathfinder.AI.IRangedAttackWrapper;
import com.zeus.pathfinder.Manager.AIManager;
import com.zeus.pathfinder.Manager.ControlManager;
import com.zeus.pathfinder.Manager.NavigationManager;

public class RemoteAttackAIItem extends AbstractAIItem
{
	private final LivingEntity targetEntity;
	private final IRangedAttackWrapper rangedAttackHost;
	private Entity attackTarget;
	private int rangedAttackTime=-1;
	private final double entityMoveSpeed;
	private int seeTime;
	private final int attackIntervalMin;
	private final int maxRangedAttackTime;
	private final float attackRadius;
	private final float maxAttackDistance;

	public RemoteAttackAIItem(LivingEntity target,IRangedAttackWrapper wrapper,double speed,int attackInterval,int maxAttackTime,float maxAttackDistanceIn) 
	{
		this.rangedAttackHost=wrapper;
	    this.targetEntity=target;
	    this.entityMoveSpeed=speed;
	    this.attackIntervalMin=attackInterval;
	    this.maxRangedAttackTime = maxAttackTime;
	    this.attackRadius = maxAttackDistanceIn;
	    this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
	}
	@Override
	public boolean shouldExecute() 
	{
		AIManager aiManager=new AIManager(targetEntity);
		if(aiManager.getGoalTarget()!=null && aiManager.getGoalTarget().getWorld().equals(this.targetEntity.getWorld()))
		{
			this.attackTarget=aiManager.getGoalTarget();
			return true;
		}
		return false;
	}
	@Override
	public boolean continueExecute()
	{
		return this.shouldExecute() || !new NavigationManager(this.targetEntity).noPath();
	}
	public double getDistanceSq() 
	{
		Location loc1=this.attackTarget.getLocation(),loc2=this.targetEntity.getLocation();
		return (loc1.getX()-loc1.getX())*(loc2.getX()-loc2.getX())+(loc1.getY()-loc1.getY())*(loc2.getY()-loc2.getY())+(loc1.getZ()-loc1.getZ())*(loc2.getZ()-loc2.getZ());
	}
	public boolean canSee() 
	{
		return true;
	}
	public float getDistanceFactor(float num,float min,float max) 
	{
	    if(num<min) 
	        return min; 
	    else
	        return num>max?max:num;
	}
	@Override
	public void upDate()
	{
		NavigationManager navigationManager=new NavigationManager(this.targetEntity);
		ControlManager controlManager=new ControlManager(this.targetEntity);
		double distanceSq=this.getDistanceSq();
		boolean canSee=this.canSee();
		if(canSee)
			this.seeTime++;
		else 
			this.seeTime=0;
		if(!(distanceSq>(double)this.maxAttackDistance) && this.seeTime>=20) 
			navigationManager.stop();
		else 
			navigationManager.navigationTo(this.targetEntity,this.entityMoveSpeed);
		controlManager.lookTicks(this.attackTarget.getLocation().getX(),this.attackTarget.getLocation().getY(),this.attackTarget.getLocation().getZ());
		if(--this.rangedAttackTime==0)
		{
			if(!canSee)
				return;
			float distance=(float) Math.sqrt(distanceSq);
			float factor=this.getDistanceFactor(distance,0.1F,1.0F);
			this.rangedAttackHost.remoteAttack(this.targetEntity,factor);
			this.rangedAttackTime=(int) Math.floor(distance*(float)(this.maxRangedAttackTime-this.attackIntervalMin)+(float)this.attackIntervalMin);
		}
		else if(this.rangedAttackTime<0)
		{
			float f=(float) (Math.sqrt(distanceSq)/this.attackRadius);
	         this.rangedAttackTime=(int) Math.floor(f*(float)(this.maxRangedAttackTime-this.attackIntervalMin)+(float)this.attackIntervalMin);
		}
	}
	@Override
	public void resetAI() 
	{
	    this.attackTarget=null;
	    this.seeTime=0;
	    this.rangedAttackTime=-1;
	}
}
