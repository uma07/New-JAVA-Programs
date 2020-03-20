package main;

import java.io.*;
import java.util.*;
import main.*;
import main.invoice.*;
import main.utility.*;
import java.util.Random;

public class InvoiceApp1File
{
	
	public static void main(String []args)
	{
		String code = "";
		double quant = 0;
		int i = 0;
		Invoice invoice = null;
		List<ProductOrder> list = new LinkedList<ProductOrder> ();
		
		if(args.length != 1)
		{
			System.out.println("Please enter as 'java main.InvoiceApp1File <input-file>' ");
			return;
		}
		
		list = ReadMyFile.readingCodesAndQuantity("input.txt");
		
		for(ProductOrder element : list)
		{
			Random num = new Random(10);
			int invoiceNum = (i++) + num.nextInt(100);
			
			Collections.sort(list);
			invoice = new Invoice(invoiceNum, list);
			list.clear();
			System.out.println(invoice);
			break;
		}
		
		StoreMyObject.store(invoice);
		
		return;
	}
	
}