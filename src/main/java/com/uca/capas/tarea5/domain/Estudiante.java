package com.uca.capas.tarea5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="estudiante")
public class Estudiante {
	@Id
	@Column(name= "c_usuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;

	@Column(name="nombre")
	@Size(max= 50, message = "Nombre no puede ser mayor a 50 char")
	@NotEmpty(message = "Requerido")
	private String name;
	
	@Column(name= "apellido")
	@Size(max= 50, message = "El apellido no debe tener mas de 50 caracteres")
	@NotEmpty(message = "Requerido")
	private String lastname;
	
	@Column(name= "carne")
	@Size(max= 10, message = "El carne no debe tener mas de 10 caracteres")
	@NotEmpty(message = "Requerido")
	private String carne;
	
	@Column(name= "carrera")
	@Size(max= 100, message = "El nombre de la carrera no debe tener mas de 100 caracteres")
	@NotEmpty(message = "Requerido")
	private String carrera;
	
	public Estudiante() {
		
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}


	
	

}