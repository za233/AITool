package com.zeus.pathfinder.Entity.Interface;

import org.bukkit.util.Vector;

public interface WatchTarget 
{
	public Vector getWatchTarget();
	public boolean hasWatchTarget();
	public void setWatchTarget(Vector s);  
	void openKeepWatchTargetFunction(int prop); 
}
