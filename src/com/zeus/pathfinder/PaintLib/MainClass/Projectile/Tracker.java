package com.zeus.pathfinder.PaintLib.MainClass.Projectile;


import org.bukkit.Location;
import org.bukkit.entity.Entity;

import com.zeus.pathfinder.PaintLib.MainClass.MyProjectile;

public class Tracker extends MyProjectile
{
	public Entity target;
	public double fix;
	public Tracker(Location loc,Entity target,double speed,double fix) 
	{
		super(loc,speed);
		this.target=target;
		this.fix=fix;
	}
	@Override
	public void render()
	{
	}
	@Override
	public boolean needDie()
	{
		return /*!this.getLocation().getWorld().getBlockAt(this.getLocation()).isEmpty() ||*/ !target.getWorld().equals(this.getLocation().getWorld()) || target.getLocation().distance(this.getLocation())<=this.R;
	}
	@Override
	public void update()
	{
		this.vec.multiply(fix);
		this.location.add(target.getLocation().subtract(this.getLocation()).toVector().normalize().multiply(speed)).add(this.vec);
	}
	@Override
	public void die()
	{
		this.getLocation().getWorld().createExplosion(this.getLocation(),3);
		this.cancelTick();
	}
}
