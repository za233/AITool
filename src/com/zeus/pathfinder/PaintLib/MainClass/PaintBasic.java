package com.zeus.pathfinder.PaintLib.MainClass;
import java.util.List;

import org.bukkit.util.Vector;

public class PaintBasic extends PaintObject
{
	public PaintBasic()
	{
		this.vx=new Vector(1,0,0);
		this.vy=new Vector(0,1,0);
		this.vz=new Vector(0,0,1);
		this.calced=false;
	}
	@Override
	public void calc() 
	{
		this.calced=true;
	}
	@Override
	public List<Vector> getList() 
	{
		return this.nodeList;
	}
	
}
