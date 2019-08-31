package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.Shape;


public class CircleScrew extends Shape
{
	private int nodeNumber=0,R=0,h=0;
	private double angle;
	public CircleScrew(int R,int nodeNumber,int h,double angle) 
	{
		this.nodeNumber=nodeNumber;
		this.R=R;
		this.h=h;
		this.angle=angle;
	}
	public double getHeight(int count)
	{
		return count;
	}
	public void getRChange()
	{
		this.R++;
	}
	public void calc()
	{
		this.nodeList.clear();
		double pi=3.1415926535,po,a=(2*pi)/nodeNumber;
		int count=0;
		while(count<h)
		{
			for(int i=1;i<=nodeNumber;i++)
			{
				po=i*a;
				double tx=Math.sin(po+angle*count)*this.R,tz=Math.cos(po+angle*count)*this.R;
				Vector news=new Vector(tx,getHeight(count),tz);
				this.nodeList.add(news);
			}
			count++;
			getRChange();
		}
		this.calced=true;
	}
}
