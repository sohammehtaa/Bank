package bankvalidations;

import java.time.LocalDate;
import java.util.List;

import bank.AccType;
import bank.Account;

public class Validation {
	
	public static LocalDate validateDate(String dt) throws CustomException
	{
		if(!LocalDate.parse(dt).isAfter(LocalDate.of(2000,01,01)))
			throw new CustomException("Invalid Admit date");
		return LocalDate.parse(dt);
	}
	
	public static AccType validateAcc(String acc)
	{
		return AccType.valueOf(acc.toUpperCase());
	}
	
	public static void validateMail(String mail) throws CustomException
	{
		String pattern = "^[^@]+@[^@]+\\.[^@]+$";
		if(!mail.matches(pattern))
			throw new CustomException("Invalid email");
	}
	
	public static void CheckDuplicate(String mail, List<Account> list) throws CustomException
	{
//		int index=list.indexOf(new Account(mail));
		if(list.contains(new Account(mail)))
				throw new CustomException("Duplicate email");
			
		
	}
	
	public static Account authenticate(String mail, String pass,List<Account> list) throws CustomException
	{
		int index=list.indexOf(new Account(mail));
		if(index!=-1)
		{
			if(!list.get(index).getPassword().equals(pass))
				throw new CustomException("Invalid password");
			return list.get(index);
		}
		else
			throw new CustomException("Invalid mail");
		
	}

	public static Account validateAll(String accno, String name, String acct, int balance, String dt, String email, String password) throws CustomException
	{
		LocalDate x=validateDate(dt);
		AccType a=validateAcc(acct);
		validateMail(email);
		
		return new Account(accno,name,a,balance,x,email,password);
	}
}
