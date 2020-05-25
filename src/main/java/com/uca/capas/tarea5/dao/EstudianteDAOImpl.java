package com.uca.capas.tarea5.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.tarea5.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public List<Estudiante> showAll() throws DataAccessException{
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM public.estudiante");
		Query statement = entityManager.createNativeQuery(sb.toString(), Estudiante.class);
		List<Estudiante> res= statement.getResultList();
		
		return res;
	}
	
	@Override
	@Transactional
	public void insertEs(Estudiante student) throws DataAccessException{
		entityManager.persist(student);
	}

	@Override
	@Transactional
	public void delete(Integer userId) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class, userId);
		entityManager.remove(estudiante);
		
	}
}
