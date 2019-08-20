package com.zeus.pathfinder.AI.AIItem.Special;

import com.zeus.pathfinder.AI.AIItem.AbstractAIItem;
import com.zeus.pathfinder.Entity.MyEntity;

public class WatchTargetAIItem extends AbstractAIItem
{
	private MyEntity target;
	public WatchTargetAIItem(MyEntity target)
	{
		this.target=target;
	}
	@Override
	public boolean shouldExecute() 
	{
		if(!this.target.hasWatchTarget() || !this.target.isSpawned() || this.target.getBukkitEntity().isDead()) 
            return false;
		return true;
	}
	@Override
	public void startExecute()
	{
		this.target.getControlHelper().lookTicks(this.target.getTargetLocation().getX(),this.target.getTargetLocation().getY(),this.target.getTargetLocation().getZ());
	}
	@Override
	public boolean continueExecute()
	{
		return this.shouldExecute();
	}
	@Override
	public void upDate()
	{
		this.startExecute();
	}
}
