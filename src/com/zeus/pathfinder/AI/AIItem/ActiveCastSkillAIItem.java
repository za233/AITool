package com.zeus.pathfinder.AI.AIItem;

import java.util.Random;

import org.bukkit.entity.LivingEntity;

import com.zeus.pathfinder.Main;
import com.zeus.pathfinder.Skills.Skill;

public class ActiveCastSkillAIItem extends AbstractAIItem
{
	final protected LivingEntity user;
	final protected Skill skill;
	final protected int T;
	final protected double damage;
	protected int chance=100;
	private int count=0;
	public ActiveCastSkillAIItem(Skill skill,LivingEntity le,int start,int T,double damage,int chance)
	{
		this.damage=damage;
		this.skill=skill;
		this.T=T;
		this.user=le;
		this.count=start;
		this.chance=chance;
	}
	public ActiveCastSkillAIItem(Skill skill,LivingEntity le,int start,int T,double damage)
	{
		this.damage=damage;
		this.skill=skill;
		this.T=T;
		this.user=le;
		this.count=start;
	}
	public ActiveCastSkillAIItem(Skill skill,LivingEntity le,int T,double damage)
	{
		this.damage=damage;
		this.skill=skill;
		this.T=T;
		this.user=le;
	}
	
	@Override
	public boolean shouldExecute() 
	{
		return true;
	}
	@Override
	public void startExecute()
	{
		count++;
		if(count%T!=0)
			return;
		count%=T;
		if(new Random().nextInt(100)<=this.chance)
		{
			if(Main.nms_ai.getGoalTarget(this.user)!=null)
				skill.cast(this.user,((LivingEntity)Main.nms_ai.getGoalTarget(this.user)),this.damage);
			else 
				skill.cast(this.user,null,this.damage);
		}
			
	}
	@Override
	public boolean continueExecute()
	{
		return this.shouldExecute();
	}
	@Override
	public void upDate()
	{
		this.startExecute();
	}
}
