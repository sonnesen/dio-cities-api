package com.github.sonnesen.citiesapi.cities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import com.github.sonnesen.citiesapi.states.entities.State;

import lombok.Data;

@Entity
@Table(name = "cidade")
@TypeDefs(value = { @TypeDef(name = "point", typeClass = PointType.class) })
@Data
public class City {

	@Id
	private Long id;

	@Column(name = "nome")
	private String name;

	@ManyToOne
	@JoinColumn(name = "uf", referencedColumnName = "id")
	private State state;

	private Integer ibge;

	@Type(type = "point")
	@Column(name = "lat_lon", updatable = false, insertable = false)
	private Point location;

}