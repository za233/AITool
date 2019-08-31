package com.zeus.pathfinder.PaintLib.MainClass;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.zeus.pathfinder.Main;


public class MyProjectile 
{
	private BukkitRunnable ticks;
	protected Vector vec,direction;
	protected Location location;
	protected double speed;
	protected double R=1;
	public void shoot(Vector v)
	{
		this.setVector(v);
		this.ticks.runTaskTimer(Main.getMain(),0,1);
	}
	public void render(){}
	public void update() {}
	public void shoot()
	{
		this.shoot(new Vector());
	}
	public void setRadius(double r)
	{
		this.R=r;
	}
	public double getRadius()
	{
		return this.R;
	}
	public void setDirection(Vector dVector)
	{
		this.direction=dVector;
	}
	public Vector getDirection()
	{
		return this.direction;
	}
	public Vector getVector()
	{
		return this.vec;
	}
	public void setVector(Vector vec)
	{
		this.vec=vec;
	}
	public Location getLocation()
	{
		return this.location;
	}
	public void setLocation(Location loc)
	{
		this.location=loc;
	}
	public MyProjectile(Location loc,double speed)
	{
		this.location=loc;
		this.speed=speed;
		this.ticks=new BukkitRunnable() 
		{
			
			@Override
			public void run() 
			{
				if(needDie())
					die();
				update();
				render();
			}
		};
	}
	public void cancelTick()
	{
		this.ticks.cancel();
	}
	public void die()
	{
		this.cancelTick();
	}
	public boolean needDie() 
	{
		return false;
	}
}
