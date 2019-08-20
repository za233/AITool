package com.zeus.pathfinder.Skills;

import org.bukkit.entity.LivingEntity;

public abstract class Skill 
{
	public abstract void cast(LivingEntity user, LivingEntity livingEntity, double damage);
}
