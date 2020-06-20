package com.github.sonnesen.citiesapi.states.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sonnesen.citiesapi.states.entities.State;
import com.github.sonnesen.citiesapi.states.repositories.StateRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/states")
@AllArgsConstructor
public class StateResource {

	private final StateRepository repository;

	@GetMapping
	public List<State> getStates() {
		return repository.findAll();
	}

}
