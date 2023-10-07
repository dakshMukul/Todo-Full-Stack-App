package com.rest.webservices.restfulwebservices.Todo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class TodoService {
    private static List<Todo> listOfTodos = new ArrayList<>();
    private static int noOfTodos = 0;

	static {
		listOfTodos.add(new Todo(++noOfTodos, "mukul", "AWS", LocalDate.now().plusYears(1), false));
		listOfTodos.add(new Todo(++noOfTodos, "mukul", "Azure", LocalDate.now().plusYears(1), false));
		listOfTodos.add(new Todo(++noOfTodos, "mukul", "React", LocalDate.now().plusYears(1), false));
	
	}

    public List<Todo> fetchAllTodos(){
        return listOfTodos; 
    }

    public List<Todo> findByUsername(String username){
        return listOfTodos.stream()
               .filter(todo -> todo.getUsername().equals(username))
               .collect(Collectors.toList());
    }

    public List<Todo> findTodoById(int id){
        return listOfTodos.stream()
               .filter(todo -> todo.getId() == id)
               .collect(Collectors.toList());
    }

    public void deleteByid(int id){
        listOfTodos.removeIf(todo -> todo.getId()==id);
    }

    public Todo addNewTodo(String name, String discription, LocalDate targetDate, boolean done ){
        Todo todo = new Todo(++noOfTodos, name, discription, targetDate, done);
        listOfTodos.add(todo);
        return todo;

    }

    public void updateTodo(int id, String description, boolean done, LocalDate targetDate){
      for (Todo todo : listOfTodos) {
        if(todo.getId() == id){
            todo.setdescription(description);
            todo.setDone(done);
            todo.setTargetDate(targetDate);
        }
      }                 
    }
    public void updateTodo(Todo todo){
        deleteByid(todo.getId());
        listOfTodos.add(todo);
    }
}