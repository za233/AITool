package com.zeus.pathfinder.AI.AIItem;

import org.bukkit.entity.Entity;

public class ExistTimeAIItem extends AbstractAIItem
{
	private Entity target;
	private int ticks,time=0;
	public ExistTimeAIItem(Entity target,int ticks)
	{
		this.target=target;
		this.ticks=ticks;
	}
	public boolean shouldExecute()
	{
		return target.isValid() && time<ticks;
	}
	public boolean continueExecute()
	{
		return this.shouldExecute();
	}
	public void startExecute()
	{
		time++;
	}
	public void upDate()
	{
		this.startExecute();
	}
	public void resetAI()
	{
		target.remove();
	}
}
