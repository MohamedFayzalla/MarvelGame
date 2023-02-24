package model.world;
import java.util.ArrayList;
import model.abilities.Ability;
import model.effects.Effect;
import java.awt.Point;
public class Champion {
	private String name;
	private int maxHP;
	private int currentHP;
	private int mana;
	private int maxActionPointsPerTurn;
	private int currentActionPoints;
	private int attackRange;
	private int attackDamage;
	private int speed;
	private ArrayList<Ability> abilities;
	private ArrayList<Effect> appliedEffects;
	private Condition condition;
	private Point location;
	private int myCoins;
	private	ArrayList<Nourishment> consumables;
public int getMyCoins() {
		return myCoins;
	}

	public void setMyCoins(int myCoins) {
		this.myCoins = myCoins;
	}

	public ArrayList<Nourishment> getConsumables() {
		return consumables;
	}

	public void setConsumables(ArrayList<Nourishment> consumables) {
		this.consumables = consumables;
	}

	public Champion(String name, int maxHP, int mana, int maxActions, int speed, int attackRange, int attackDamage) 
	{ 	//added this
		this.condition=Condition.ACTIVE;
		this.myCoins=1000;
		consumables=new ArrayList<Nourishment>();
		this.name=name;
		this.currentHP=maxHP;
		this.maxHP=maxHP;
		this.mana=mana;
		this.maxActionPointsPerTurn=maxActions;
		this.currentActionPoints=maxActions;
		this.speed=speed;
		this.attackRange=attackRange;
		this.attackDamage=attackDamage;
		this.currentHP=maxHP;
		abilities=new ArrayList<Ability>();
		appliedEffects=new ArrayList<Effect>();
	}
	
	public void setCurrentActionPoints(int currentActionPoints) {
		if(currentActionPoints<=0)
			this.currentActionPoints=0;
		else
		if(currentActionPoints>=maxActionPointsPerTurn)
			this.currentActionPoints=maxActionPointsPerTurn;
		else {
			
		this.currentActionPoints = currentActionPoints;
		}
	}
	public int getCurrentHP() {
		return currentHP;
	}
	
	public void setCurrentHP(int currentHP) {
		if(currentHP>=maxHP) 
			this.currentHP=maxHP;
		else if(currentHP<=0)
			this.currentHP=0;
		else
			this.currentHP = currentHP;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}
	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}
	public int getAttackDamage() {
		return attackDamage;
	}
	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public Point getLocation() {
		return location;
	}
	public void setLocation(Point location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getMana() {
		return mana;
	}
	public int getCurrentActionPoints() {
		return currentActionPoints;
	}
	public int getAttackRange() {
		return attackRange;
	}
	public ArrayList<Ability> getAbilities() {
		return abilities;
	}
	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}
	

}
