package main.products.db;

import main.products.*;

public class ProductDB
{
    public static Product getProduct(String productCode)
    {
        // In a more realistic application, this code would
        // get the data for the product from a file or database
        // For now, this code just uses if/else statements
        // to return the correct product data

        Product p = null;

        if (productCode.equalsIgnoreCase("TPDE") ||
           productCode.equalsIgnoreCase("AI") ||
           productCode.equalsIgnoreCase("TOS"))
        {
            Book b = new Book();
            if (productCode.equalsIgnoreCase("TPDE"))
            {
                b.setCode(productCode);
                b.setDescription("Theory of Partial Differential Equations");
                b.setPrice(300.00);
                b.setAuthor("Lawrence.C.Evans");
            }
            else if (productCode.equalsIgnoreCase("AI"))
            {
                b.setCode(productCode);
                b.setDescription("Introduction to Artificial Intelligence");
                b.setPrice(437.00);
                b.setAuthor("Stuart Russell");
            }
            else if (productCode.equalsIgnoreCase("TOS"))
            {
                b.setCode(productCode);
                b.setDescription("Theory of Statistics");
                b.setPrice(159.50);
                b.setAuthor("B.C.Harrison");
            }
            p = b; // set Product object equal to the Book object
        }
        else if (productCode.equalsIgnoreCase("txt"))
        {
            Software s = new Software();
            s.setCode("txt");
            s.setDescription("TextPad");
            s.setPrice(27.00);
            s.setVersion("4.7.3");
            p = s; // set Product object equal to the Software object
        }
        else if (productCode.equalsIgnoreCase("wrdpd"))
		{
			Software s = new Software();
			s.setCode("wrdpd");
			s.setDescription("Word Pad");
			s.setPrice(37.00);
			s.setVersion("6.3.3");
			p = s; // set Product object equal to the Software object
        }
        else
        {
        	System.out.println("Sorry !!! There is no product matching with this product code.\n");
        }
        return p;
    }
}
