package model.world;

import java.util.ArrayList;

public class Human {
private	int maxHealth;
private	int currentHealth;
	private ArrayList<Gear> gears;
	
	public Human(int maxHealth) 
	{
		this.maxHealth=maxHealth;
		this.currentHealth=maxHealth;
		gears=new ArrayList<Gear>();
		
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		if(currentHealth>=maxHealth)
			this.currentHealth=maxHealth;
		else if(currentHealth<=0)
			this.currentHealth=0;
		else
		this.currentHealth = currentHealth;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public ArrayList<Gear> getGears() {
		return gears;
	}
	

}
