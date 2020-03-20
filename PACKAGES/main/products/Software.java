package main.products;

import main.products.*;

public class Software extends Product
{
	private String version ;
	
	public Software()
	{
		this.version = "" ;
	}
	
	public void setVersion(String ver)
	{
		this.version = ver ;
	}
	
	public String getVersion()
	{
		return "Version: " + this.version + "\n" ;
	}
	
	public String toString()
	{
		return "Code:        " + this.getCode() + "\n" +
               "Description: " + this.getDescription() + "\n" +
               "Price:       " + this.getFormattedPrice() + "\n" +
               "Version:     " + this.version + "\n" +
			   "Tags : " + this.getTags() + "\n";
        }
}	
	
		
