package com.cogent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.entity.Author;
import com.cogent.repository.AuthorRepository;
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	public List<Author> fetchAuthorList() {
		return (List<Author>) authorRepository.findAll();
	}
	
	//Single Item get
	public Optional<Author> get(int authorId){
		return authorRepository.findById(authorId);
	}
	
	//Get all items
	public List<Author> getAll(){
		return (List<Author>) authorRepository.findAll();
	}
	
	//Update item
	public Optional<Author> update(Author author) {
		Author authorToUpdate = authorRepository.findById(author.getAuthorId()).get();
		
		authorToUpdate.setAuthorName(author.getAuthorName());
		authorToUpdate.setAuthorAddress(author.getAuthorAddress());
		authorToUpdate.setAuthorPhone(author.getAuthorPhone());
		authorToUpdate.setAuthorId(author.getAuthorId());
		
		authorRepository.save(authorToUpdate);
		return authorRepository.findById(author.getAuthorId());
	}
	
	//create item
	public Author insert(Author author) {
		return authorRepository.save(author);
	}
	
	//Delete item
	public void delete(Author author) {
		authorRepository.deleteById(author.getAuthorId());
	}
	
	//Delete all items
	public void deleteAll() {
		authorRepository.deleteAll();
	}

}
