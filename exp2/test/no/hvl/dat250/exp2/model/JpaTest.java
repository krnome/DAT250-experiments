package no.hvl.dat250.exp2.model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

public class JpaTest {
	
	private static final String PERSISTENCE_UNIT_NAME = "people";
	private EntityManagerFactory factory;

	@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("select m from Person m");
		
		boolean createNewEntries = (q.getResultList().size() == 0);
		
		if(createNewEntries) {
			//Fra tutorial - har jo allerede sjekket dette
			assertTrue(q.getResultList().size() == 0);
			
			Family family = new Family();
			family.setDescription("Teste familie");
			em.persist(family);
			for(int i = 0; i < 40; i++) {
				Person person = new Person();
				person.setFirstName("Fornavn " + i);
				person.setLastName("Etternavn " + i);
				person.setFamily(family);
				family.getMembers().add(person);
				
				
				em.persist(person);
				em.persist(family);
			}
		}
		
		em.getTransaction().commit();
		em.close();
	}
	
	@Test
	public void checkAvailablePeople() {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createQuery("select m from Person m");
		
		assertTrue(q.getResultList().size() == 40);
		
		em.close();
		
	}
	
	@Test
    public void checkFamily() {
        EntityManager em = factory.createEntityManager();
        // Go through each of the entities and print out each of their
        // messages, as well as the date on which it was created
        Query q = em.createQuery("select f from Family f");

        // We should have one family with 40 persons
        assertTrue(q.getResultList().size() == 1);
        assertTrue(((Family) q.getSingleResult()).getMembers().size() == 40);
        em.close();
    }

    @Test(expected = javax.persistence.NoResultException.class)
    public void deletePerson() {
        EntityManager em = factory.createEntityManager();
        // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName");
        q.setParameter("firstName", "Fornavn 1");
        q.setParameter("lastName", "Etternavn 1");
        Person user = (Person) q.getSingleResult();
        em.remove(user);
        em.getTransaction().commit();
        Person person = (Person) q.getSingleResult();
        // Begin a new local transaction so that we can persist a new entity

        em.close();
    }

}
