package enteties;

public class NewItem {
	private Item _product;
	private int _bonus;
	
	public NewItem(Item prod,int bonus)
	{
		_product = prod;
		_bonus = bonus;
	}
	
	public NewItem(Item prod)
	{
		_product = prod;
		_bonus = 0;
	}
	
	public void SetBonus(int newBonus)
	{
		this._bonus = newBonus;
	}
	
	public int Cost(int itemCount)
	{	
		if(!(this._bonus > 1))
			this._bonus = 1;
		
		int sum = 0;
		int bonus = (int)(this._product.GetPrice() - (this._product.GetPrice() * this._bonus));
		
		
		sum += this._product.GetPrice() * 100;
		itemCount -=100;
		
		while(itemCount > 100)
		{
			sum += bonus * 100;
			itemCount -=100;
		}
		
		sum += bonus * itemCount;
		
		return sum;
	}
	
	public int NewCost(int itemCount)
	{
		
		if(!(this._bonus > 1))
			this._bonus = 1;
		
		int sum = 0;
		int bonus = (int)(this._product.GetPrice() - (this._product.GetPrice() * this._bonus));
		int currPrice =(int) this._product.GetPrice();
		
		sum += currPrice * 100;
		itemCount -=100;
		
		
		
		while(itemCount > 100)
		{
			
			sum += currPrice * 100;
			itemCount -=100;
			currPrice = currPrice - currPrice * bonus > (int)(this._product.GetPrice()/2) ? currPrice = currPrice - currPrice * bonus : currPrice;
		}
		
		sum += currPrice * itemCount;
		
		return sum;
	}
	
}
