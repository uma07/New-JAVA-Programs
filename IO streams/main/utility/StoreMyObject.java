package main.utility;

import java.io.Serializable;
import java.io.*;
import java.util.*;
import main.invoice.*;

public class StoreMyObject
{
	public static void store(Invoice invoice)
	{
		try
		{
			FileOutputStream file = new FileOutputStream("MyProductOrders");
			ObjectOutputStream out = new ObjectOutputStream(file);
		
			out.writeObject(invoice);
		}
		
		catch(FileNotFoundException e1)
		{
			System.out.println("Sorry !!! File is not found");
			return;
		}
		
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
	}
	
	public static void write()
	{
		
	}

}