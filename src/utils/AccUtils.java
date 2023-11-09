package utils;

import java.util.ArrayList;
import java.util.List;
import static bankvalidations.Validation.validateAll;

import bank.Account;
import bankvalidations.CustomException;

public class AccUtils {
	public static List<Account> populateAcc() throws CustomException
	{
		List<Account> list= new ArrayList<>();
		list.add(validateAll("1","krishna","saving",400000,"2001-05-18","km123@gmail.com","km"));
		list.add(validateAll("2","soham","fixed",700000,"2006-12-20","sm123@gmail.com","sm"));
		list.add(validateAll("3","deep","current",200000,"2001-01-06","dk123@gmail.com","dk"));
		list.add(validateAll("4","suyash","saving",500000,"2001-12-31","sk123@gmail.com","sk"));
		list.add(validateAll("5","soha","fixed",900000,"2019-03-08","sl123@gmail.com","sl"));
		return list;
	}
}
