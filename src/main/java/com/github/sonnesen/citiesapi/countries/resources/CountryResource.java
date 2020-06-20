
package com.github.sonnesen.citiesapi.countries.resources;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sonnesen.citiesapi.countries.entities.Country;
import com.github.sonnesen.citiesapi.countries.repositories.CountryRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryResource {

	private CountryRepository repository;

	@GetMapping
	public Page<Country> getCountries(Pageable page) {
		return repository.findAll(page);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Optional<Country> optional = repository.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok().body(optional.get());
		else
			return ResponseEntity.notFound().build();
	}
}
