package com.github.sonnesen.citiesapi.distances.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.sonnesen.citiesapi.distances.services.DistanceService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/distances")
@RequiredArgsConstructor
public class DistanceResource {

	Logger log = LoggerFactory.getLogger(DistanceResource.class);

	@NonNull
	private final DistanceService service;

	@GetMapping("by-points")
	public ResponseEntity<Double> getByPoints(@RequestParam(name = "from") final Long aCity,
			@RequestParam(name = "to") final Long otherCity) {
		log.info("byPoints");
		return ResponseEntity.ok().body(service.getDistanceByPointsInMiles(aCity, otherCity));
	}

	@GetMapping("by-cube")
	public ResponseEntity<Double> getByCube(@RequestParam(name = "from") final Long aCity,
			@RequestParam(name = "to") final Long otherCity) {
		log.info("byCube");
		return ResponseEntity.ok().body(service.getDistanceByCubeInMeters(aCity, otherCity));
	}
}
