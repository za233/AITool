package com.zeus.pathfinder.AI.v1_10_R1;

import com.zeus.pathfinder.AI.AIItem.AbstractAIItem;

import net.minecraft.server.v1_10_R1.PathfinderGoal;

public class PathfinderGoalInterface extends PathfinderGoal
{	
	private AbstractAIItem aiItem;
	public PathfinderGoalInterface(AbstractAIItem ai) 
	{
		
		this.aiItem=ai;
	}
	@Override
	public boolean a() 
	{
		return this.aiItem.shouldExecute();
	}
	@Override
	public void c()
	{
		this.aiItem.startExecute();
	}
	@Override
	public boolean b()
	{
		return this.aiItem.continueExecute();
	}
	@Override
	public void d()
	{
		this.aiItem.resetAI();
	}
	@Override
	public void e()
	{
		this.aiItem.upDate();
	}
}
