package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.Shape;

public class Eye extends Shape
{
	protected double angle,d;
	protected int nodeNumber;
	public Eye(double angle,double d,int nodeNumber)
	{
		this.angle=angle;
		this.d=d;
		this.nodeNumber=nodeNumber;
	}
	public void calc()
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
			Vector news=new Vector(tx-x,0,tz);
			this.nodeList.add(news);
			news=new Vector(x-tx,0,tz);
			this.nodeList.add(news);
		}
		double r=d*(1-Math.cos(angle_/2));
		Circle circle=new Circle(r,nodeNumber);
		circle.calc();
		this.nodeList.addAll(circle.getList());
	}
}
