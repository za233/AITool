package com.zeus.pathfinder.PaintLib.MainClass;

import org.bukkit.util.Vector;

public class VectorGet 
{
	private Vector vx,vy,vz;
	public VectorGet()
	{
		this.vx=new Vector(1,0,0);
		this.vy=new Vector(0,1,0);
		this.vz=new Vector(0,0,1);
	}
	public VectorGet(Vector vx,Vector vy,Vector vz)
	{
		this.vx=vx;
		this.vy=vy;
		this.vz=vz;
	}
	public VectorGet(Vector vy)
	{
		this.vy=vy.normalize();
		double a=vy.getX(),b=vy.getY(),c=vy.getZ();
		this.vx=new Vector(c,c,-a-b).normalize();
		this.vz=new Vector((b*b+a*b+c*c),-(a*a+a*b+c*c),c*(b-a)).normalize();
	}
	public void normalize()
	{
		this.vx=this.vx.normalize();
		this.vy=this.vy.normalize();
		this.vz=this.vz.normalize();
	}
	public Vector getX()
	{
		return this.vx;
	}
	public Vector getY()
	{
		return this.vy;
	}
	public Vector getZ()
	{
		return this.vz;
	}
}
