package main.products;

import main.products.interfaces.*;
import java.text.NumberFormat;

public abstract class Product implements java.lang.Comparable,Tagable
{
    private String code,tags;
    private String description;
    private double price;
    public static int count = 0;

    public Product()
    {
        code = "";
        description = "";
		tags="";
        price = 0;
        count ++ ;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public String getFormattedPrice()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
	
	public String getTags()
	{
		return tags;
	}
	
	public void setTags(String S)
	{
		if(tags == "")
			tags = S;
		else
			tags = tags + ", " + S;
	}

    public String toString()
    {
        return "Code:        " + code + "\n" +
               "Description: " + description + "\n" +
               "Price:       " + this.getFormattedPrice() + "\n" +
			   "Tags : " + this.getTags() + "\n";
    }

    public static int getCount()
    {
        return count;
    }
	
	public int compareTo(Object P)
	{
		Product S = (Product)P;
		return this.code.compareTo(S.code);
	}
}
