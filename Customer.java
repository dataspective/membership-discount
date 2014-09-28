
public class Customer {
	private static double totalPurchases;
	private double newAmount;
	private boolean discount;

	
	public Customer ()
	{
		totalPurchases = 0;
	}
	
	public void makePurchase(double amount)
	{	
		
		if (discount)
		{
			newAmount = amount * 0.9;
			System.out.println("Thank you for your purchase of $" + amount);
			System.out.println("Your discount has been applied. The original purchase of $" + amount + " is now $" + newAmount + ". \nToday you saved: $" + (amount - newAmount));
			
			totalPurchases = totalPurchases - 100;
			discount = false;
		}
		else 
		{
			System.out.println("Thank you for your payment of $" + amount + ".");
			totalPurchases += amount;
			discountReached();
			
			if (discount)
			{
				System.out.println("For being a loyal customer, we've given you a 10% discount. This will be automatically applied to your next purchase.");
			}
			else
			{
			System.out.println("You are $" + (100 - totalPurchases) + " away from your next discount.");
			}
		}
	}
	
	public boolean discountReached()
	{
		if (totalPurchases >= 100)
		{
			discount = true;
		}
		return discount;
	}
}
