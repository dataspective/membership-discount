/**
 * OOP_Business_P8.4 Customer loyalty campaign (50 pts)  Page 416-417
 * @author Derek Fermaint
 * Program to apply discount to customer membership account.
 * 
 * NOTE: at first I wrote it that when the customer hit 100, the discount would apply and reset progress back to zero.
 * 		However, this is not fair to the customer. So I rewrote it that EVERY 100 they purchase, they get a single 10% discount. 
 * 		The test class shows this at the very end, that it all keeps track of every 100 they spend.
 */
public class Customer {
	private static double totalPurchases;
	private double newAmount;
	private boolean discount;
	
	private final double DISCOUNT_INCREMENT = 100;
	private final double DISCOUNT_RATE = 0.9;

	/**
	 * Customer new membership constructor with initial value of zero
	 */
	public Customer ()
	{
		totalPurchases = 0;
	}
	
	/**
	 * Enters purchase amount
	 * Checks whether customer has a discount
	 * If customer has discount, applies 10% discount rate to purchase
	 * 		NOTE: final variable used so rate can be edited easier at a later date
	 * Then takes 100 away from membership total amount spent, and takes back the discount
	 * Or
	 * If customer doesn't have discount, but makes payment to where total amount spent is greater than 100
	 * Lets customer know their next purchase will have an automatic discount applied
	 * Or
	 * If customer doesn't have discount and payment did not exceed 100, let's them know how close they are to next discount
	 * @param amount currency value of customer's purchase
	 */
	public void makePurchase(double amount)
	{	
		
		if (discount)
		{
			newAmount = amount * DISCOUNT_RATE;
			System.out.println("Thank you for your purchase of $" + amount);
			System.out.println("Your discount has been applied. The original purchase of $" + amount + " is now $" + newAmount + ". \nToday you saved: $" + (amount - newAmount));
			
			totalPurchases = totalPurchases - DISCOUNT_INCREMENT;
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
			System.out.println("You are $" + (DISCOUNT_INCREMENT - totalPurchases) + " away from your next discount.");
			}
		}
	}
	
	/**
	 * Applied customer discount. This is checked inside 'makePurchase() else' and reset inside 'makePurchase() if'
	 * @return discount true/false
	 */
	public boolean discountReached()
	{
		if (totalPurchases >= DISCOUNT_INCREMENT)
		{
			discount = true;
		}
		return discount;
	}
}
