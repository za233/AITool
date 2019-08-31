package com.zeus.pathfinder.PaintLib.MainClass;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.util.Vector;

public class Shape extends PaintBasic implements VectorChange
{

	@Override
	public Vector ChangeVector(Vector loc) 
	{
		double x=loc.getX()*vx.getX()+loc.getY()*vy.getX()+loc.getZ()*vz.getX();
		double y=loc.getX()*vx.getY()+loc.getY()*vy.getY()+loc.getZ()*vz.getY();
		double z=loc.getX()*vx.getZ()+loc.getY()*vy.getZ()+loc.getZ()*vz.getZ();
		Vector ans=new Vector(x,y,z);
		return ans;
	}
	
	@Override
	public List<Vector> ChangeAllVector()
	{
		List<Vector> newlist=new ArrayList<Vector>();
		if(this.nodeList==null)
			return null;
		for(Vector loc:this.nodeList)
			newlist.add(ChangeVector(loc));
		return newlist;
	}
	@Override
	public void setVectorGet(VectorGet vg)
	{
		this.vx=vg.getX();
		this.vy=vg.getY();
		this.vz=vg.getZ();
	}
	@Override
	public void SplayX(double n) 
	{
		this.vx.multiply(n);
	}

	@Override
	public void SplayY(double n) 
	{
		this.vy.multiply(n);
	}

	@Override
	public void SplayZ(double n) 
	{
		this.vz.multiply(n);
	}

	@Override
	public void SplayAll(double n) 
	{
		SplayX(n);	
		SplayY(n);
		SplayZ(n);
	}

	@Override
	public void normalize() 
	{
		this.vx=new Vector(1,0,0);
		this.vy=new Vector(0,1,0);
		this.vz=new Vector(0,0,1);
	}
	@Override
	public VectorGet getVectorGet() 
	{
		return new VectorGet(this.vx,this.vy,this.vz);
	}

	@Override
	public List<Vector> rotateX(double x) 
	{
		double pi=3.1415926535,po=(x/360.0)*2*pi;
		List<Vector> ans=new ArrayList<Vector>();
		for(Vector v:this.nodeList)
		{
			double R=Math.sqrt(v.getY()*v.getY()+v.getZ()*v.getZ());
			if(R==0)
			{
				ans.add(v);
				continue;
			}
			double sin=v.getY()/R,cos=v.getZ()/R;
			double sin_=sin*Math.cos(po)+cos*Math.sin(po);
			double cos_=cos*Math.cos(po)-sin*Math.sin(po);
			ans.add(new Vector(v.getX(),R*sin_,R*cos_));
		}
		this.nodeList=ans;
		return ans;
	}

	@Override
	public List<Vector> rotateY(double y) 
	{
		double pi=3.1415926535,po=(y/360.0)*2*pi;
		List<Vector> ans=new ArrayList<Vector>();
		for(Vector v:this.nodeList)
		{
			double R=Math.sqrt(v.getX()*v.getX()+v.getZ()*v.getZ());
			if(R==0)
			{
				ans.add(v);
				continue;
			}
			double sin=v.getX()/R,cos=v.getZ()/R;
			double sin_=sin*Math.cos(po)+cos*Math.sin(po);
			double cos_=cos*Math.cos(po)-sin*Math.sin(po);
			ans.add(new Vector(R*sin_,v.getY(),R*cos_));
		}
		this.nodeList=ans;
		return ans;
	}

	@Override
	public List<Vector> rotateZ(double z) 
	{
		double pi=3.1415926535,po=(z/360.0)*2*pi;
		List<Vector> ans=new ArrayList<Vector>();
		for(Vector v:this.nodeList)
		{
			double R=Math.sqrt(v.getX()*v.getX()+v.getY()*v.getY());
			if(R==0)
			{
				ans.add(v);
				continue;
			}
			double sin=v.getX()/R,cos=v.getY()/R;
			double sin_=sin*Math.cos(po)+cos*Math.sin(po);
			double cos_=cos*Math.cos(po)-sin*Math.sin(po);
			ans.add(new Vector(R*sin_,R*cos_,v.getZ()));
		}
		this.nodeList=ans;
		return ans;
	}
	

}
