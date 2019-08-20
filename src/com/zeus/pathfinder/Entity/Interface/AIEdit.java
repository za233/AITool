package com.zeus.pathfinder.Entity.Interface;

import com.zeus.pathfinder.Manager.AIManager;

public interface AIEdit 
{
	public void removeAttackAI() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;
	public AIManager getAIManager();
}
