package com.zeus.pathfinder.Entity.Interface;

import org.bukkit.util.Vector;

public interface MoveTarget
{
	public Vector getTargetLocation();
	public void setTargetLocation(Vector s); 
	public double getSpeedToLocation();
	public void setSpeedToLocation(double s); 
	public boolean hasTargetLocation();
	void openTargetLocationFunction(int prop);
}
