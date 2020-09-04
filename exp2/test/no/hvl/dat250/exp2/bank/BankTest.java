package no.hvl.dat250.exp2.bank;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "bank";
	private EntityManagerFactory factory;

	
	@Before
	public void Setup() throws Exception {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		//em.getTransaction().begin();
		
		
		
	}
	

}
