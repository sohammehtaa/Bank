package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import bank.Account;

public class IOUtils {

	public static void storeDetails(List<Account> list,String filename) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out= new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(out);
		}
	}
	
	public static Object restoreDetails(String filename) throws ClassNotFoundException, IOException
	{
		try(ObjectInputStream in= new ObjectInputStream(new FileInputStream(filename)))
		{
			return in.readObject();
		}
	}
}
