package no.hvl.dat250.exp2.bank;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Address {

	@Id
	private int id;
	private String Street;
	private int number;
	
	@ManyToMany(mappedBy="addresses")
	private List<Person> residents;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	public List<Person> getResidents() {
		return residents;
	}

	public void setResidents(List<Person> residents) {
		this.residents = residents;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", Street=" + Street + ", number=" + number + ", residents=" + residents + "]";
	}
	
	
	
	
	
	
}
