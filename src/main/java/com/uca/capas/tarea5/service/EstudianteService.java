package com.uca.capas.tarea5.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.tarea5.domain.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> showAll() throws DataAccessException;
	
	public void insertEs(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer userId) throws DataAccessException;

}
