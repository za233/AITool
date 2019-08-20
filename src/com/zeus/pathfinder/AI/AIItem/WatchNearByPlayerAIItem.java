package com.zeus.pathfinder.AI.AIItem;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.zeus.pathfinder.Manager.ControlManager;

public class WatchNearByPlayerAIItem extends AbstractAIItem
{
	private LivingEntity livingEntity;
	private double dist;
	public WatchNearByPlayerAIItem(LivingEntity le,double distance)
	{
		this.livingEntity=le;
		this.dist=distance;
	}
	public Player getNearByPlayer(Location loc,double dist)
	{
		Player targetPlayer=null;
		double dis=dist;
		for(Player p:loc.getWorld().getPlayers())
		{
			if(p.getLocation().distance(loc)>dis)
				continue;
			if(p.getLocation().distance(loc)<=dis)
			{
				dis=p.getLocation().distance(loc);
				targetPlayer=p;
			}
				
		}
		return targetPlayer;
	}
	@Override
	public boolean shouldExecute() 
	{
		
		return this.livingEntity.isValid() && getNearByPlayer(livingEntity.getEyeLocation(),this.dist)!=null;
	}
	@Override
	public void startExecute()
	{
		ControlManager ch=new ControlManager(this.livingEntity);
		ch.lookTicks(getNearByPlayer(livingEntity.getEyeLocation(),this.dist).getEyeLocation().getX(),getNearByPlayer(livingEntity.getEyeLocation(),this.dist).getEyeLocation().getY(),getNearByPlayer(livingEntity.getEyeLocation(),this.dist).getEyeLocation().getZ());
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
