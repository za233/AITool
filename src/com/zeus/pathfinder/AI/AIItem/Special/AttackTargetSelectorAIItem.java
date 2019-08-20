package com.zeus.pathfinder.AI.AIItem.Special;


import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import com.zeus.pathfinder.AI.AIItem.AbstractAIItem;
import com.zeus.pathfinder.Entity.MyEntity;
import com.zeus.pathfinder.Manager.AIManager;

public class AttackTargetSelectorAIItem extends AbstractAIItem
{
	private MyEntity target;
	public AttackTargetSelectorAIItem(MyEntity target)
	{
		this.target=target;
	}
	@Override
	public boolean shouldExecute() 
	{
		if(!this.target.hasTarget() || !this.target.isSpawned() || this.target.getBukkitEntity().isDead() || this.target.getTarget().isDead()) 
            return false;
		return true;
	}
	@Override
	public void startExecute()
	{
		AIManager aiManager=new AIManager(this.target.getBukkitEntity());
		aiManager.setGoalTarget(this.target.getTarget(),TargetReason.CUSTOM);
	}
	@Override
	public void resetAI()
	{
		AIManager aiManager=new AIManager(this.target.getBukkitEntity());
		aiManager.setGoalTarget(null,TargetReason.FORGOT_TARGET);
	}
	@Override
	public void upDate() 
	{
		this.startExecute();
	}
	@Override
	public boolean continueExecute()
	{
		return this.shouldExecute();
	}
}
