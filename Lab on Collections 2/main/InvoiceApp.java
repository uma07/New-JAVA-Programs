package main;

import java.util.*;
import main.products.*;
import main.products.db.*;
import main.invoice.*;
import main.utility.*;
import java.util.Random;
import main.sales.*;

public class InvoiceApp
{
	
	public static void main(String[] args)
	{
		String temp = new String();
		String ch = new String();
		ch = "y";
		int quantity;
		int i = 0;
		LinkedList<ProductOrder> list = new LinkedList<ProductOrder>();
		LinkedList<Invoice> invList = new LinkedList<Invoice>();
		Invoice in;
		Product s;
		ProductOrder p;
		SalesReport rep;
		
		while(ch.equals("y"))
		{
			Random num = new Random(10);
			int invoiceNum = (i++) + num.nextInt(100);
			i++;
			
			while(ch.equals("y"))
			{
				System.out.println("Enter any product code from the following : ");
				System.out.println("\n TPDE (Theory of PDE) ");
				System.out.println(" AI (Artificial Intelligence)");
				System.out.println(" TOS (Thoeory of stats)");
				System.out.println(" txt (Text Pad)");
				System.out.println(" wrdpd (Word Pad)\n");

				temp = Validator.getString("");

				System.out.println("Enter the quantity : ");

				s = ProductDB.getProduct(temp);
				quantity = Validator.getInt("");
				p = new ProductOrder(temp, quantity);
			
				if(p != null)
				{
					list.add(p);
					temp = Validator.getString("Do you want to insert tags? (y/n): ");
					while(true)
					{
						if(temp.equals("y") || temp.equals("Y"))
						{
							temp = Validator.getString("\nEnter tag: ");
							s.setTags(temp);
						}
						else
							break;
						
						temp = Validator.getString("continue to insert tags? (y/n): ");
						if(temp.equals("n"))
							break;
					}
					
					System.out.println(s);
				}

				ch = Validator.getString("\nIf you are done, then enter 'done'. Else, enter 'y' : ") ;

			
				if(ch.equals("done"))
				{	
					Collections.sort(list);
					in = new Invoice(invoiceNum, list);
					list.clear();
					System.out.println(in);
					invList.add(in);
					break;
				}
			}
			
			System.out.println("Do u want to enter one more invoice ? ");
			ch = Validator.getString("\nIf no enter 'done'. Else enter 'y' : ");
			
			if(ch.equals("done"))
				break;
		}
		
		rep = new SalesReport(invList);
		System.out.println("REPORT : ");
		System.out.println("-------- ");
		System.out.println(rep);
	}
	
}