
import java.util.List;
import java.util.Scanner;
import static bankvalidations.Validation.*;
import static utils.IOUtils.*;
import static utils.AccUtils.populateAcc;

import bank.Account;

public class Tester {
	public static void main (String[] args)
	{
		try(Scanner sc= new Scanner(System.in))
		{
			try
			{
				List<Account> list=populateAcc();
				
				System.out.println("-----> BANK <-----");
				System.out.println("\n1.Sign up \n2.Sign in \n3.change Password \n4.Display all \n5.Natural Sorting \n6.Custom Sorting \n7.Unsubscribe \n8.Exit");
				boolean exit=false;
				
				while(!exit)
				{
					System.out.println("Enter choice:");
					switch(sc.nextInt())
					{
						case 1:
							System.out.println("Sign up");
							System.out.println("Enter details :");
							System.out.println("String accno, String name, String acct, int balance, String dt, String email, String password");
							list.add(validateAll(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.next(),sc.next(),sc.next()));
							System.out.println("You can now Sign in !");
							//6 phalguni current 300000 2023-03-08 pb123@gmail.com pb
							break;
							
						case 2:
							System.out.println("Sign in");
							System.out.println("Enter email and password");
							authenticate(sc.next(),sc.next(),list);
							System.out.println("Signed in");
							System.out.println("Restoring details");
							restoreDetails("bank");
							break;
							
						case 3:
							System.out.println("Change password");
							System.out.println("Enter email and password");
							Account a=authenticate(sc.next(),sc.next(),list);
							a.setPassword(sc.next());
							System.out.println("Password Updated");
							break;
						case 4:
							System.out.println("Account details");
							list.stream().forEach(System.out::println);
							break;
							
						case 5:
							System.out.println("natural sorting");
							list.stream().sorted().forEach(System.out::println);
							break;
							
						case 6:
							System.out.println("custom order");
							list.stream().sorted((a1,a2)->(a1.getAccOpeningDate().compareTo(a2.getAccOpeningDate()))).forEach(System.out::println);
							break;
							
						case 7:
							System.out.println("Unsubscribe");
							break;
							
						case 8:
							storeDetails(list,"bank");
							exit=true;
							break;
					}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
