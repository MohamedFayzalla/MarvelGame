package model.world;
import java.awt.Point;
public class Cover {
	private int currentHP;
	private Point location;
	public Cover(int x,int y) 
	{
		this.location =new Point(x,y);
		currentHP=(int)(100+Math.random()*900);
		
	}
	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		if(currentHP<=0)
			this.currentHP=0;
		else {
		this.currentHP = currentHP;
		}
	}
	public Point getLocation() {
		return location;
	}
	
	

}
