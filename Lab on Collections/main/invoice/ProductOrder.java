package main.invoice;

import java.util.*;
import main.products.*;
import main.products.db.*;

public class ProductOrder implements java.lang.Comparable<ProductOrder>
{

	private Product product; 
	private double quantity;
	private double total;
	public static int ocount = 0;
	private String tags;

	public ProductOrder(String code, double quantity)
	{
		product = ProductDB.getProduct(code);
		this.quantity = quantity;
		total = quantity * product.getPrice();
		++ocount;
	}
	
	public int compareTo(ProductOrder p)
	{
		return (int)(this.total - p.total);
	}
	
	public String toString()
	{
		return "Code : " + product.getCode() + "\n" +
				"Quantity : " + quantity + "\n" +
				"Total : " + total + "\n";
	}
	
	public double getPRICE()
	{
		return product.getPrice();
	}
	
	public double getTotal()
	{
		return total;
	}
	
	public static int getCount()
	{
		return ocount;
	}
	
	public String getTags()
	{
		return tags;
	}
	
	public String getCODE()
	{
		return product.getCode();
	}
	
	public void setQuantity(double quant)
	{
		quantity = quant;
	}
	
	public void setTotal(double quant)
	{
		total = quantity * product.getPrice();
	}
	
	public double getQuantity()
	{
		return quantity;
	}
	
	public void setTags(String S)
	{
		if(tags == "")
			tags = S;
		else
			tags = tags + ", " + S;
	}

}