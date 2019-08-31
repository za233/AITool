package com.zeus.pathfinder.AI;

import org.bukkit.entity.LivingEntity;

public interface IRangedAttackWrapper 
{
	public void remoteAttack(LivingEntity attacker,double distanceFactor);
}
