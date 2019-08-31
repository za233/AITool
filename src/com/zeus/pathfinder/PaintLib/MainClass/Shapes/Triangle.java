package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.Line;
import com.zeus.pathfinder.PaintLib.MainClass.Shape;

public class Triangle extends Shape
{
	public Vector v1,v2,v3;
	public double len=0.1;
	public Triangle(Vector v1,Vector v2,Vector v3,double len)
	{
		this.v1=v1;
		this.v2=v2;
		this.v3=v3;
		this.len=len;
	}
	public void calc()
	{
		this.nodeList.clear();
		Line l1=new Line(v1.clone(),v2.clone(),len);
		Line l2=new Line(v2.clone(),v3.clone(),len);
		Line l3=new Line(v3.clone(),v1.clone(),len);
		l1.calc();l2.calc();l3.calc();
		this.nodeList.addAll(l1.getList());
		this.nodeList.addAll(l2.getList());
		this.nodeList.addAll(l3.getList());
		this.calced=true;
	}
}
