package com.zeus.pathfinder.AI.v1_14_R1;

import org.bukkit.entity.Entity;

import com.zeus.pathfinder.AI.Attribute_Util_Main;

import net.minecraft.server.v1_14_R1.IAttribute;
import net.minecraft.server.v1_14_R1.AttributeInstance;
import net.minecraft.server.v1_14_R1.GenericAttributes;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftLivingEntity;;
public class Attribute_Util implements Attribute_Util_Main
{
	@Override
	public void setFollowRange(Entity e, double range) 
	{
		
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.FOLLOW_RANGE);
        if (attributes!=null)
            attributes.setValue(range);
	}

	@Override
	public void setKnockBackResistance(Entity e, double val) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.KNOCKBACK_RESISTANCE);
        if (attributes!=null)
            attributes.setValue(val);
	}

	@Override
	public void setSpeed(Entity e, double speed) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.MOVEMENT_SPEED);
        if (attributes!=null)
            attributes.setValue(speed);
	}

	@Override
	public void setAttackDamage(Entity e, double val) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.ATTACK_DAMAGE);
        if (attributes!=null)
            attributes.setValue(val);
	}
	@Override
	public void setMaxHealth(Entity e, double val) 
	{
		AttributeInstance attributes=(AttributeInstance)(((CraftLivingEntity)e).getHandle()).getAttributeInstance((IAttribute)GenericAttributes.MAX_HEALTH);
        if (attributes!=null)
            attributes.setValue(val);
	}
}
