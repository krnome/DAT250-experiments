package no.hvl.dat250.exp2.bank;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	
	private static final String PERSISTENCE_UNIT_NAME = "bank";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {

		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		
		Bank bank = new Bank();
		bank.setId(1);
		bank.setName("Bank 1");
				
		Pincode pincode = new Pincode();
		pincode.setId(1);
		pincode.setPincode("1234");
		pincode.setCount(1);
		
		CreditCard creditcard = new CreditCard();
		creditcard.setId(1);
		creditcard.setBalance(1000);
		creditcard.setIssuedByBank(bank);
		creditcard.setLimit(5000);
		creditcard.setNumber(2468);
		creditcard.setPincode(pincode);
		
		Person person = new Person();
		person.setName("Person 1");

		creditcard.setOwner(person);
		
		Address address = new Address();
		address.setId(1);
		address.setStreet("Testeveien");
		address.setNumber(1);
		
		person.setAddresses(new ArrayList<Address>());
		person.getAddresses().add(address);
		
		em.getTransaction().begin();
		em.persist(bank);
		em.persist(pincode);
		em.persist(creditcard);
		em.persist(address);
		em.persist(person);
		
		
		em.getTransaction().commit();
		
		em.close();
		
		em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT p from Person p");
		Person p = (Person) q.getSingleResult();
		
		System.out.println("PERSON: " + p);
		System.out.println("ADDRESS: " + p.getAddresses().get(0));
		em.close();
		
	}

}
