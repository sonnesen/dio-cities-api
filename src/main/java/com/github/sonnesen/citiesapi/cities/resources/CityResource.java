package com.github.sonnesen.citiesapi.cities.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sonnesen.citiesapi.cities.entities.City;
import com.github.sonnesen.citiesapi.cities.repositories.CityRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityResource {

	private final CityRepository repository;

	@GetMapping
	public Page<City> getCities(final Pageable page) {
		return repository.findAll(page);
	}
}
