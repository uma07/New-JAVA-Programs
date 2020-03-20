package main.invoice;

import main.invoice.*;
import java.util.Calendar;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Invoice implements Serializable
{
	
		private int	invoiceNumber;
		private Date date = new Date();
		private List<ProductOrder> list;
		private double total;
		private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		public Invoice(int num, List<ProductOrder> l)
		{
			invoiceNumber = num;
			list = new LinkedList<ProductOrder>(l);
			
			for (ProductOrder element : list)
				total = total + element.getTotal();
		}
		
		public String toString()
		{
			return "Invoice Number : " + invoiceNumber + "\n" +
					"Date : " + sdf.format(date) + "\n" + "Total : " + total + "\n" + list + "\n";
		}

}