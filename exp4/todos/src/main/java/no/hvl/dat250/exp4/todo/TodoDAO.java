package no.hvl.dat250.exp4.todo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TodoDAO {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("todos_exp4");
	EntityManager em = emf.createEntityManager();
	
	public List<Todo> findAllTodos(){
		return em.createQuery("SELECT t from Todo t", Todo.class).getResultList();
	}
	
	public Todo findTodo(Long id) {
		return em.find(Todo.class, id);
	}
	
	public Todo updateTodo(Todo todo) {
		
		//Todo todoToUpdate = em.find(Todo.class, todo.getId());
		
		em.getTransaction().begin();
		Todo updatedTodo = em.merge(todo);
		em.getTransaction().commit();
		
		return updatedTodo;
	}
	
	public Todo saveNewTodo(Todo todo) {
		em.getTransaction().begin();
		em.persist(todo);
		em.getTransaction().commit();
		return todo;
	}
	
	public void deleteTodo(Todo todo) {
		em.getTransaction().begin();
		em.remove(todo);
		em.getTransaction().commit();
	}
	
	public void deleteTodoById(Long id) {
		Todo todoToDelete = em.find(Todo.class, id);
		
		em.getTransaction().begin();
		em.remove(todoToDelete);
		em.getTransaction().commit();
	}

}
