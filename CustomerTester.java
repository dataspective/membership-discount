/**
 * Please review notes in Customer.java for context of this file
 * @author Derek Fermaint
 *
 */
public class CustomerTester {
	
	public static void main(String[] args)
	{
		Customer sagan = new Customer();
		
		//customer earns discount
		sagan.makePurchase(100);
		System.out.println();
		//makes over 90, but not 100. discount is applied but second discount is not created
		sagan.makePurchase(95);
		System.out.println();
		//earns second discount
		sagan.makePurchase(20);
		sagan.makePurchase(30);
		sagan.makePurchase(134);
		System.out.println();
		//applied it
		sagan.makePurchase(20);
		System.out.println();
		//another purchase to make sure no discount is true and it has set to 0
		sagan.makePurchase(5);
		System.out.println();
	}
}
