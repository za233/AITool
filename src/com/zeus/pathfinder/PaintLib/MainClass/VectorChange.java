package com.zeus.pathfinder.PaintLib.MainClass;
import java.util.List;

import org.bukkit.util.Vector;

public interface VectorChange
{
	public void setVectorGet(VectorGet vg);
	public VectorGet getVectorGet();
	public List<Vector> rotateX(double x);
	public List<Vector> rotateY(double y);
	public List<Vector> rotateZ(double z);
	public Vector ChangeVector(Vector v);
	public List<Vector> ChangeAllVector();
	public void SplayX(double n);
	public void SplayY(double n);
	public void SplayZ(double n);
	public void SplayAll(double n);
	public void normalize();
}
