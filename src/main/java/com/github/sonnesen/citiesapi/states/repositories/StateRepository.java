package com.github.sonnesen.citiesapi.states.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.sonnesen.citiesapi.states.entities.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
