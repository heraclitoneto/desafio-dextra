package com.pratica.dextra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.dextra.model.Users;
import com.pratica.dextra.repository.UsersRepository;

@RestController
@RequestMapping("/potterApi/users")
public class UserController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping
	public List<Users> listar() {
		return usersRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Users getUsersById(@PathVariable Long id) {
		return usersRepository.findById(id).get();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Users adicionar(@RequestBody Users users) {		
		return usersRepository.save(users);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		usersRepository.deleteById(id);
	}

}
