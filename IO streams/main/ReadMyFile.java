package main;

import java.util.*;
import java.io.*;
import main.products.*;
import main.invoice.*;

public class ReadMyFile
{

	public static  List<ProductOrder> readingCodesAndQuantity(String file)
	{
		List<ProductOrder> list = new LinkedList<ProductOrder>();
		String code;
		int quant;
		FileReader in;
		BufferedReader bufferedReader;

		try
		{
			in = new FileReader(file);
			bufferedReader = new BufferedReader(in);
		}

		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}

		try
		{
			while(true)
			{
				code = bufferedReader.readLine();

				if(code != null)
				{
					try
					{
						quant = Integer.parseInt(bufferedReader.readLine());
					}

					catch(NumberFormatException e1)
					{
						System.out.println("Soory !!! Invalid quantity input");
						break;
					}

					try
					{
						list.add(new ProductOrder(code,quant));
					}

					catch(Exception e2)
					{
						System.out.println("Sorry !!! Invalid input");
						break;
					}
				}

				else
					break;
			}
		}

		catch(IOException e3)
		{
			e3.printStackTrace();
		}

		return list;
	}

}