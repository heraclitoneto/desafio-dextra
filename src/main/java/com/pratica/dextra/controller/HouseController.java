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

import com.pratica.dextra.model.House;
import com.pratica.dextra.repository.HouseRepository;

@RestController
@RequestMapping("/potterApi/houses")
public class HouseController {
	
	@Autowired
	private HouseRepository houseRepository;
	
	@GetMapping
	public List<House> allHouses() {
		return houseRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public House BuscaId(@PathVariable Long id) {
		return houseRepository.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void deleteHouse (@PathVariable Long id) {
		houseRepository.deleteById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public House AddHouse (@RequestBody House house) {
		return houseRepository.save(house);
	}

}
