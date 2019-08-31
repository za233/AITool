package com.zeus.pathfinder.AI.AIItem;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.zeus.pathfinder.Manager.ControlManager;

public class WatchNearByPlayerAIItem extends AbstractAIItem
{
	private LivingEntity livingEntity;
	private double distance;
	public WatchNearByPlayerAIItem(LivingEntity le,double distance)
	{
		this.livingEntity=le;
		this.distance=distance;
	}
	public Player getNearByPlayer(Location loc,double distance)
	{
		Player targetPlayer=null;
		double dis=distance;
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
		
		return this.livingEntity.isValid() && getNearByPlayer(livingEntity.getEyeLocation(),this.distance)!=null;
	}
	@Override
	public void startExecute()
	{
		ControlManager controlManager=new ControlManager(this.livingEntity);
		controlManager.lookTicks(getNearByPlayer(livingEntity.getEyeLocation(),this.distance).getEyeLocation().getX(),getNearByPlayer(livingEntity.getEyeLocation(),this.distance).getEyeLocation().getY(),getNearByPlayer(livingEntity.getEyeLocation(),this.distance).getEyeLocation().getZ());
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
