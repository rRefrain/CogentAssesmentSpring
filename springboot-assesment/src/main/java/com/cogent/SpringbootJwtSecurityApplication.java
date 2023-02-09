	package com.cogent;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cogent.entity.Author;
import com.cogent.entity.User;
import com.cogent.repository.AuthorRepository;
import com.cogent.repository.UserRepository;

@SpringBootApplication
public class SpringbootJwtSecurityApplication {
	 @Autowired
	    private UserRepository repository;
	 
	 @Autowired
	 	private AuthorRepository authorRepository;

	    @PostConstruct
	    public void initUsers() {
	        List<User> users = Stream.of(
	                new User(101, "gyanendra", "password", "gsytec@gmail.com"),
	                new User(102, "user1", "pwd1", "user1@gmail.com"),
	                new User(103, "user2", "pwd2", "user2@gmail.com"),
	                new User(104, "user3", "pwd3", "user3@gmail.com")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	    }
	    
	    @PostConstruct
	    public void initAuthor() {
	        List<Author> authors = Stream.of(
	                new Author(1, "Akira", "777 Springfield, USA", "422-222-2222"),
	                new Author(2, "Ren", "555 Geary Avenue", "555-555-5555"),
	                new Author(3, "Hirano", "Shibuya, 42-42", "290-290-2902"),
	                new Author(4, "Yuriya", "Urahara, 902-2932", "890-890-8908")
	        ).collect(Collectors.toList());
	        authorRepository.saveAll(authors);
	    }

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtSecurityApplication.class, args);
	}

}
