package com.zeus.pathfinder.PaintLib.MainClass;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Line extends PaintBasic
{
	public Vector from,to;
	public double len;
	public Line(Vector from,Vector to,double len)
	{
		this.to=to;
		this.from=from;
		this.len=len;
	}
	public Line(Location from,Location to,double len)
	{
		this.to=to.toVector();
		this.from=from.toVector();
		this.len=len;
	}
	public void calc()
	{
		Vector v=to.clone().subtract(from.clone()).normalize().multiply(len);
		int n=(int)(from.distance(to)/len);
		while(n>=0)
		{
			n--;
			Vector news=from.clone();
			this.nodeList.add(news);
			from.add(v);
		}
		this.calced=true;
	}
}
