package itemsPackage;

public class Potion_Healing extends Super_Item{
	
	public final int amount = 1;
	
	public Potion_Healing(){
		
		
		
			///int amount = 1;
			name = "Healing Potion " + "["+amount+"]";
			healingValue = 20;
			sellingPrice= 20;
			buyingPrice= 30;
			
			amountStackable = 5;
		
		
	
	}
	
	
	
	
	public int stacking(int amount){
		
		
		amount++;
		return amount;
		
		
		
	}
}
