package com.zeus.pathfinder.AI.AIItem;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityTargetEvent.TargetReason;

import com.zeus.pathfinder.Main;
import com.zeus.pathfinder.Entity.MyEntity;
import com.zeus.pathfinder.Manager.AIManager;

public class ProtectPlayerAIItem extends AbstractAIItem
{
	private LivingEntity protectEntity;
	private Player player;
	public ProtectPlayerAIItem(Player p,MyEntity e)
	{
		this.player=p;
		this.protectEntity=e.getBukkitEntity();
	}
	public ProtectPlayerAIItem(Player p,LivingEntity e)
	{
		this.player=p;
		this.protectEntity=e;
	}
	@Override
	public boolean shouldExecute()
	{
		if(!this.protectEntity.isDead() && Main.nms_ai.getLastDamager(this.player)!=null && Main.nms_ai.getLastDamager(this.player).isValid())
			return true;
		return false;
	}
	@Override
	public void startExecute()
	{
		AIManager aiManager=new AIManager(this.protectEntity);
		aiManager.setGoalTarget((LivingEntity)Main.nms_ai.getLastDamager(this.player),TargetReason.OWNER_ATTACKED_TARGET);
	}
	@Override
	public void resetAI()
	{
		AIManager aiManager=new AIManager(this.protectEntity);
		aiManager.setGoalTarget(null,TargetReason.FORGOT_TARGET);
	}
	@Override
	public void upDate() 
	{
		this.startExecute();
	}
	@Override
	public boolean continueExecute()
	{
		return this.shouldExecute();
	}
	
}
