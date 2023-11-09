package bank;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Account implements Serializable{

	public String getPassword() {
		return password;
	}

	private String accountNumber;
	private String name;
	private String email;
	private String password;
	private AccType acct;
	private long balance;
	private LocalDate accOpeningDate;
	private LocalDate last_trans_dt;
	private boolean isActive;

	public LocalDate getAccOpeningDate() {
		return accOpeningDate;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Account)
		{
			Account other = (Account) obj;
			return Objects.equals(accountNumber, other.accountNumber);
		}
		
		return false;
	}

	public Account(String accountNumber, String name, AccType acct, long balance, LocalDate accOpeningDate,String email,String password) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.acct = acct;
		this.balance = balance;
		this.accOpeningDate = accOpeningDate;
		this.email=email;
		this.password=password;
		this.last_trans_dt=LocalDate.now();
		this.isActive=true;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", email=" + email + ", password="
				+ password + ", acct=" + acct + ", balance=" + balance + ", accOpeningDate=" + accOpeningDate + "]";
	}


	public Account(String email) {
		super();
		this.email = email;
	}
	
}
