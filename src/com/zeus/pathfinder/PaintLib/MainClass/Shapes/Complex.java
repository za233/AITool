package com.zeus.pathfinder.PaintLib.MainClass.Shapes;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.util.Vector;

import com.zeus.pathfinder.PaintLib.MainClass.PaintBasic;
import com.zeus.pathfinder.PaintLib.MainClass.Shape;



public class Complex extends Shape
{
	public List<PaintBasic> ComplexList=new ArrayList<PaintBasic>();
	public Complex(List<PaintBasic> list)
	{
		this.ComplexList=list;
	}
	public void calc()
	{
		this.nodeList.clear();
		for(PaintBasic s:this.ComplexList)
		{
			s.calc();
			List<Vector> c=s.getList();
			this.nodeList.addAll(c);
		}
		this.calced=true;
	}
}
