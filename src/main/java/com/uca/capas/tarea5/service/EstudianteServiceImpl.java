package com.uca.capas.tarea5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.tarea5.dao.EstudianteDAO;
import com.uca.capas.tarea5.domain.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> showAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteDAO.showAll();
	}

	@Override
	@Transactional
	public void insertEs(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDAO.insertEs(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer userId) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteDAO.delete(userId);
		
	}
	
	

}
