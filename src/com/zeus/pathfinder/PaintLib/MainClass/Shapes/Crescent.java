package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.Shape;



public class Crescent extends Shape
{
	protected double angle1,angle2,d;
	protected int nodeNumber;
	public Crescent(double angle1,double angle2,double d,int nodeNumber)
	{
		this.angle1=angle1;
		this.angle2=angle2;
		this.d=d;
		this.nodeNumber=nodeNumber;
	}
	public void calcone(double angle)
	{
		double pi=3.1415926535;
		double angle_=(angle/360)*2*pi;
		double x=0;
		if(Math.tan(angle_/2)!=0)
			x=d/Math.tan(angle_/2);
		double po,a=(angle_)/nodeNumber;
		for(int i=1;i<=nodeNumber;i++)
		{
			po=i*a+pi/2-angle_/2;
			double tx,tz,R=d;
			if(Math.sin(angle_/2)!=0)
				R=(d/Math.sin(angle_/2));
			tx=Math.sin(po)*R;tz=Math.cos(po)*R;
			Vector news=new Vector(0,tx-x,tz);
			this.nodeList.add(news);
		}
	}
	public void calc()
	{
		this.nodeList.clear();
		calcone(this.angle1);
		calcone(this.angle2);
	}
	
}
