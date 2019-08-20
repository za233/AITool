package com.zeus.pathfinder.AI.AIItem.Special;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import com.zeus.pathfinder.AI.AIItem.AbstractAIItem;

public class AIGoalSelector 
{
	private Map<String,AbstractAIItem> AIGoalMap;
    private List<AbstractAIItem> AIGoalList;
    private List<AbstractAIItem> activeAIGoalList;
    
    public AIGoalSelector() 
    {
        super();
        this.AIGoalMap=new HashMap<String,AbstractAIItem>();
        this.AIGoalList=new LinkedList<AbstractAIItem>();
        this.activeAIGoalList=new LinkedList<AbstractAIItem>();
    }
    
    public void addGoal(final String name,final AbstractAIItem goal) 
    {
        if(this.AIGoalMap.containsKey(name)) 
            return;
        this.AIGoalMap.put(name,goal);
        this.AIGoalList.add(goal);
    }
    
    public void addGoal(final String name,final int pos,final AbstractAIItem myPetAIgoal) 
    {
        if (this.AIGoalMap.containsKey(name))
            return;
        this.AIGoalMap.put(name, myPetAIgoal);
        this.AIGoalList.add(pos, myPetAIgoal);
    }
    
    public void replaceGoal(final String name,final AbstractAIItem goal) 
    {
        if (this.AIGoalMap.containsKey(name)) 
        {
            final AbstractAIItem oldGoal=(AbstractAIItem)this.AIGoalMap.get(name);
            if (this.activeAIGoalList.contains(oldGoal)) 
            {
                this.activeAIGoalList.remove(oldGoal);
                oldGoal.resetAI();
            }
            final int index=this.AIGoalList.indexOf(oldGoal);
            this.AIGoalList.add(index,goal);
            this.AIGoalList.remove(oldGoal);
            this.AIGoalMap.put(name,goal);
            return;
        }
        this.addGoal(name,goal);
    }
    
    public void removeGoal(final String name) 
    {
        if (this.AIGoalMap.containsKey(name)) 
        {
            final AbstractAIItem goal=(AbstractAIItem)this.AIGoalMap.get(name);
            this.AIGoalList.remove(goal);
            this.AIGoalMap.remove(name);
            if (this.activeAIGoalList.contains(goal)) 
                goal.resetAI();
            this.activeAIGoalList.remove(goal);
        }
    }
    
    public boolean hasGoal(final String name) 
    {
        return this.AIGoalMap.containsKey(name);
    }
    
    public AbstractAIItem getGoal(final String name) 
    {
        return this.AIGoalMap.get(name);
    }
    
    public void clearGoals() 
    {
        this.AIGoalList.clear();
        this.AIGoalMap.clear();
        for(final AbstractAIItem goal:this.activeAIGoalList)
            goal.resetAI();
        this.activeAIGoalList.clear();
    }
    
    public void finish() 
    {
        for(final AbstractAIItem goal:this.activeAIGoalList)
            goal.resetAI();
        this.activeAIGoalList.clear();
    }
    
    public void tick() 
    {
        ListIterator<AbstractAIItem> iterator=this.AIGoalList.listIterator();
        while(iterator.hasNext()) 
        {
            final AbstractAIItem goal=(AbstractAIItem)iterator.next();
            if(!this.activeAIGoalList.contains(goal) && goal.shouldExecute()) 
            {
                goal.startExecute();
                this.activeAIGoalList.add(goal);
            }
        }
        iterator=this.activeAIGoalList.listIterator();
        while (iterator.hasNext()) 
        {
            final AbstractAIItem goal=(AbstractAIItem)iterator.next();
            if (!goal.continueExecute()) 
            {
                goal.resetAI();
                iterator.remove();
            }
        }
        iterator=this.activeAIGoalList.listIterator();
        while(iterator.hasNext()) 
        {
            final AbstractAIItem goal=(AbstractAIItem)iterator.next();
            goal.upDate();
        }
    }
}
