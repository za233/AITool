package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.Shape;



public class Ball extends Shape
{
	private int n;
	private double R;
	public Ball(double R,int n)
	{
		this.R=R;
		this.n=n;
	}
	public void calc()
	{
		this.nodeList.clear();
		double pi=3.1415926535,po,a=(2*pi)/n;
		for(int i=0;i<=n/2;i++)
		{
			po=pi/2-i*a;
			double tx=Math.sin(po)*this.R,tz=Math.cos(po)*this.R;
			Circle c=new Circle(tz,n);
			c.calc();
			List<Vector> ans=new ArrayList<Vector>();
			for(Vector v:c.getList())
			{
				v.add(new Vector(0,tx,0));
				ans.add(v);
			}
			this.nodeList.addAll(ans);
		}
		this.calced=true;
	}
}
