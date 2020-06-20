package com.github.sonnesen.citiesapi.countries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.sonnesen.citiesapi.countries.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
