package com.zeus.pathfinder.PaintLib.MainClass;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.util.Vector;

public abstract class PaintObject 
{
	protected Vector vx,vy,vz;
	protected boolean calced;
	protected List<Vector> nodeList=new ArrayList<Vector>();
	public abstract void calc();
	public abstract List<Vector> getList();
}
