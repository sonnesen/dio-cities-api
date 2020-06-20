package com.github.sonnesen.citiesapi.distances.services;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import com.github.sonnesen.citiesapi.cities.entities.City;
import com.github.sonnesen.citiesapi.cities.repositories.CityRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DistanceService {

	Logger log = LoggerFactory.getLogger(DistanceService.class);

	@NonNull
	private final CityRepository cityRepository;

	public Double getDistanceByPointsInMiles(final Long city1, final Long city2) {
		log.info("nativePostgresInMiles({}, {})", city1, city2);
		return cityRepository.getDistanceByPoints(city1, city2);
	}

	public Double getDistanceByCubeInMeters(Long city1, Long city2) {
		log.info("distanceByCubeInMeters({}, {})", city1, city2);
		final List<City> cities = cityRepository.findAllById((Arrays.asList(city1, city2)));

		Point p1 = cities.get(0).getLocation();
		Point p2 = cities.get(1).getLocation();

		return cityRepository.getDistanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
	}

}
