package com.cogent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.entity.Author;

import com.cogent.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	//Get All items
	@GetMapping(value= {"/authors"})
	public List<Author> getAll(){
		List<Author> authors = authorService.getAll();
		System.out.println("authors retrieved "+authors.size());
		return authors;
	}
	//Get an item
	@GetMapping("/authors/{id}")
	public Author get(@PathVariable("id") Integer id) {
		Optional<Author> i = authorService.get(id);
		return i.get();
	}
	//Insert an item
	@PostMapping("/authors")
	public Author add(@RequestBody Author author) {
		return authorService.insert(author);
	}
	//Update an item
	@PutMapping("/authors")
	public Author edit(@RequestBody Author author) {
		return authorService.update(author).get();
	}
	//Delete an item
	@DeleteMapping("/authors")
	public String delete(@RequestBody Author author) {
		authorService.delete(authorService.get(author.getAuthorId()).get());
		return "authors id "+author.getAuthorId()+" deleted successfully";
	}
}
