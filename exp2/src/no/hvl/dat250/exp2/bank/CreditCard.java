package no.hvl.dat250.exp2.bank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CreditCard {
	
	@Id
	private int id;
	
	private int number;
	private int limit;
	private int balance;
	
	//Ingen annotasjoner - blir koblet implisitt
	private Pincode pincode;
	
	@ManyToOne
	private Person owner;
	
	@ManyToOne
	private Bank issuedByBank;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	
	public Pincode getPincode() {
		return pincode;
	}

	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}

	
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	
	
	public Bank getIssuedByBank() {
		return issuedByBank;
	}

	public void setIssuedByBank(Bank issuedByBank) {
		this.issuedByBank = issuedByBank;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", number=" + number + ", limit=" + limit + ", balance=" + balance
				+ ", pincode=" + pincode + ", owner=" + owner + ", issuedByBank=" + issuedByBank + "]";
	}
	
	
	
	

}
