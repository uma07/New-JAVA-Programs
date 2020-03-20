package main.sales;

import java.util.*;
import main.invoice.*;
import main.utility.*;
import main.products.db.*;

public class SalesReport
{
	
	Map<String, ProductOrder> reportMap;
	
	public SalesReport(List<Invoice> list)
	{
		reportMap = new HashMap<String, ProductOrder>();
		for(Invoice inv : list)
		{
			List<ProductOrder> ordList = inv.getList();
			
			for(ProductOrder pro : ordList)
			{
				if(reportMap.containsKey(pro.getCODE()))
				{
					reportMap.get( pro.getCODE() ).setQuantity( reportMap.get( pro.getCODE() ).getQuantity() + pro.getQuantity() );
					reportMap.get( pro.getCODE() ).setTotal( reportMap.get( pro.getCODE() ).getQuantity() );
				}
				
				else
					reportMap.put(pro.getCODE(), pro);
			}
		}
	}

	public String toString()
	{

		double price = 0;
		double quantity = 0;
		String prodCode = "";
		Double total = 0.0;
		Double tot = 0.0;
		int  i= 0 ;
		double grandTotal = 0;
		String output = String.format("%15s %15s %15s %15s", "Product Code", "Qnty Sold", "Price", "Total");
		output = output + String.format("\n%15s %15s %15s %15s", "------- ----", "---- ----", "-----", "-----");
		for(Map.Entry<String, ProductOrder> entry : reportMap.entrySet())
		{
			prodCode = entry.getKey();
			quantity = reportMap.get(entry.getKey()).getQuantity();
			price = reportMap.get(entry.getKey()).getPRICE();
			tot = reportMap.get(entry.getKey()).getTotal();
			total = total + tot;
			output = output + String.format("\n%15s %15f %15f %15f", prodCode, quantity, price, tot);
		}
		
		output = output + "\n\nOverall Total of the purchases : " + total.toString();
		return output;

	}

}