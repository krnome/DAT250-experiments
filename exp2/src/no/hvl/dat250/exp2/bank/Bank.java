package no.hvl.dat250.exp2.bank;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	
	@Id
	private int id;
	
	private String name;

	@OneToMany(mappedBy="issuedByBank")
	private List<CreditCard> creditCards;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", creditCards=" + creditCards + "]";
	}
	
	
	
	
}
