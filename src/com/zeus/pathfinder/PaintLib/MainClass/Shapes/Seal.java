package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.PaintBasic;
import com.zeus.pathfinder.PaintLib.MainClass.Shape;


public class Seal extends Shape
{
	private Complex complex;
	public Seal(double R) 
	{
		R/=2;
		Triangle c1=new Triangle(new Vector(0,0,2*R),new Vector(-1.73205*R,0,-1*R),new Vector(1.73205*R,0,-1*R),0.3);
		Triangle c2=new Triangle(new Vector(1.73205*R,0,1*R),new Vector(-1.73205*R,0,1*R),new Vector(0,0,-2*R),0.3);
		Circle c=new Circle(2*R,(int)(30*R));
		List<PaintBasic> slist=new ArrayList<PaintBasic>();
		slist.add(c1);
		slist.add(c2);
		slist.add(c);
		this.complex=new Complex(slist);
		
	}
	public void calc()
	{
		complex.calc();
		this.nodeList=this.complex.getList();
		this.calced=true;
	}
}
