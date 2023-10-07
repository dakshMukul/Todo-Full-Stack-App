package com.rest.webservices.restfulwebservices.Todo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.restfulwebservices.Todo.Todo;


public interface TodoRepository  extends JpaRepository<Todo, Integer>{
    
    public List<Todo> findByUsername(String username);
}
