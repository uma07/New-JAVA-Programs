package main.products;

import main.products.*;

public class Book extends Product
{
	private String author ;
	
	public Book()
	{
		this.author = "" ;
	}
	
	public void setAuthor(String name)
	{
		this.author = name ;
	}

	public String getAuthor()
	{
		return "Author: " + this.author + "\n" ;
	}
	
	public String toString()
	{
		return "Code:        " + this.getCode() + "\n" +
               "Description: " + this.getDescription() + "\n" +
               "Price:       " + this.getFormattedPrice() + "\n" +
               "Author:      " + this.author + "\n" +
			   "Tags : " + this.getTags() + "\n";
        }
        
}
