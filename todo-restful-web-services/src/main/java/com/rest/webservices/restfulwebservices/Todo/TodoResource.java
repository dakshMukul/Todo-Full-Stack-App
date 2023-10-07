package com.rest.webservices.restfulwebservices.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// @RestController
public class TodoResource {
    
    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> findByUsername(@PathVariable String username){
        return todoService.findByUsername(username);
    }
    @GetMapping("/users/{username}/todos/{id}")
    public List<Todo> findByid(@PathVariable int id){
        return todoService.findTodoById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteByid(@PathVariable String username, @PathVariable int id){
        todoService.deleteByid(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(@PathVariable String username,
     @PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(todo);
        return todo;
     }
    @PostMapping("/users/{username}/todos")
    public Todo addTodo(@PathVariable String username, @RequestBody Todo todo){
        Todo createdTodo = todoService.addNewTodo(username , todo.getdescription(), todo.getTargetDate(),todo.getDone());
        return createdTodo;
     }
}
