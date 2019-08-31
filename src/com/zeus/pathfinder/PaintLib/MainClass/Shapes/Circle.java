package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.Shape;



public class Circle extends Shape
{
	public int nodeNumber=0;
	public double R=0;
	public Circle(double R,int nodeNumber) 
	{
		this.nodeNumber=nodeNumber;
		this.R=R;
	}
	public void calc()
	{
		this.nodeList.clear();
		double pi=3.1415926535,po,a=(2*pi)/nodeNumber;
		for(int i=1;i<=nodeNumber;i++)
		{
			po=i*a;
			double tx=Math.sin(po)*this.R,tz=Math.cos(po)*this.R;
			Vector news=new Vector(tx,0,tz);
			this.nodeList.add(news);
		}
		this.calced=true;
	}
}
