package model.world;

public class BoughtItem extends Nourishment{
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int price;
	public BoughtItem(String name, int nourishmentAmount, int manaIncreased, NourishmentType type,int price) 
	{
		super(name,nourishmentAmount,manaIncreased,type);
		this.price=price;
		
	}

}
