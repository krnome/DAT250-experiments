package no.hvl.dat250.exp2.bank;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person {
	
	@Id
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "person_lives_at_address", joinColumns = @JoinColumn(name = "person_id"),inverseJoinColumns = @JoinColumn(name = "address_id"))
	private List<Address> addresses;
	
	@OneToMany(mappedBy="owner")
	private List<CreditCard> creditCards;
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	@Override
	public String toString() {
		return "Person [name=" + name +  ", addresses="
				+ addresses + ", creditCards=" + creditCards + "]";
	}
	
	
	
	

}
