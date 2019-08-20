package com.zeus.pathfinder.AI.v1_7_R4;

import org.bukkit.entity.Entity;

import com.zeus.pathfinder.AI.Attribute_Util_Main;

import net.minecraft.server.v1_7_R4.IAttribute;
import net.minecraft.server.v1_7_R4.AttributeInstance;
import net.minecraft.server.v1_7_R4.GenericAttributes;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftLivingEntity;;
public class Attribute_Util implements Attribute_Util_Main
{

	@Override
	public void setFollowRange(Entity e, double range) 
	{
		
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.b);
        if (attributes!=null)
            attributes.setValue(range);
	}

	@Override
	public void setKnockBackResistance(Entity e, double val) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.c);
        if (attributes!=null)
            attributes.setValue(val);
	}

	@Override
	public void setSpeed(Entity e, double speed) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.d);
        if (attributes!=null)
            attributes.setValue(speed);
	}

	@Override
	public void setAttackDamage(Entity e, double val) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.e);
        if (attributes!=null)
            attributes.setValue(val);
	}
	@Override
	public void setMaxHealth(Entity e, double val) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.maxHealth);
        if (attributes!=null)
            attributes.setValue(val);
	}
}
