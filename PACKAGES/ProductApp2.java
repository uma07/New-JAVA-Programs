package main;

import main.utility.*;
import main.products.*;
import main.products.db.*;

public class ProductApp2
{
	public static void main(String[] args)
	{
		String temp = new String();
		Product p[];
		p=new Product[10];
		Product s;
		while(true)
		{
			System.out.println("Enter any product code from the following : ");
			System.out.println("\n TPDE (Theory of PDE) ");
			System.out.println(" AI (Artificial Intelligence)");
			System.out.println(" TOS (Thoeory of stats)");
			System.out.println(" txt (Text Pad)");
			System.out.println(" wrdpd (Word Pad)\n");
			temp = Validator.getString("");
			s = ProductDB.getProduct(temp);
			if(s != null)
			{
				
				p[Product.getCount() - 1] = s;
				temp = Validator.getString("Do you want to insert tags? (y/n): ");
				while(true)
				{
					if(temp.equals("y") || temp.equals("Y"))
					{
						temp = Validator.getString("\nEnter tag: ");
						p[Product.getCount() - 1].setTags(temp);
					}
					else
						break;
					temp = Validator.getString("continue to insert tags? (y/n): ");
					if(temp.equals("n"))
						break;
				}
				System.out.println(s);
			}

			temp = Validator.getString("\nContinue to enter product name? (y/n) : ") ;
			
			if(temp.equals("n"))
			{	
				System.out.println(Product.getCount() + " objects are created.\n") ;
				java.util.Arrays.sort(p,0,Product.getCount());
				
				for(int i=0; i < Product.getCount(); i++)
				{
					System.out.println(p[i]);
				}
				return ;
			}
		}
	}
}