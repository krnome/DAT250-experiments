package no.hvl.dat250.exp4.todo;

import static spark.Spark.port;

import java.util.List;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.put;
import static spark.Spark.delete;
import static spark.Spark.post;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.gson.Gson;

public class App {

	private static final String PERSISTENCE_UNIT_NAME = "todos_exp4";
	private static EntityManagerFactory emf;
	
	public static void main(String[] args) {
		
		
		TodoDAO todoDAO = new TodoDAO();
		
		if (args.length > 0) {
			port(Integer.parseInt(args[0]));
		} else {
			port(8080);
		}
		
		after((req, res) -> {
			res.type("application/json");
		});
		
		
		get("/todos", (req, res) -> {
			
			
			List<Todo> todoList = todoDAO.findAllTodos();
				
			Gson gson = new Gson();
			String jsonInString = gson.toJson(todoList);
			return jsonInString;
			
		});
		
		get("/todos/:id", (req, res) -> {
			
			Todo todo =  todoDAO.findTodo(Long.parseLong(req.params(":id")));
			if(todo != null) {
				return todo.toJson();
			} else {
				return new Gson().toJson("Todo with id: " + req.params(":id") + " not found!");
			}
			
			
		});
		
		post("/todos", (req, res) -> {
			Gson gson = new Gson();
			Todo newTodo = gson.fromJson(req.body(), Todo.class);
			Todo savedTodo = todoDAO.saveNewTodo(newTodo);
			
			return savedTodo.toJson();
		});
		
		
		
		put("/todos/:id", (req, res) -> {
			Gson gson = new Gson();
			
			Todo todoFromRequest = gson.fromJson(req.body(), Todo.class);
			todoFromRequest.setId(Long.parseLong(req.params(":id")));
			
			Todo updatedTodo = todoDAO.updateTodo(todoFromRequest);
			
			return updatedTodo.toJson();
			
			
		});
		
		delete("/todos/:id", (req, res) -> {
			todoDAO.deleteTodoById(Long.parseLong(req.params(":id")));
			return new Gson().toJson("Todo deleted");
		});
		

	}

}
