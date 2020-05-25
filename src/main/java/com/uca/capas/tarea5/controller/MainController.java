package com.uca.capas.tarea5.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.tarea5.dao.EstudianteDAO;
import com.uca.capas.tarea5.domain.Estudiante;
import com.uca.capas.tarea5.service.EstudianteService;

@Controller
public class MainController {
	@Autowired
	private EstudianteService service;
	
	@RequestMapping("/inicio")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		Estudiante stu = new Estudiante();
		mav.addObject("student", stu);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> studentsList = null;
		try {
			studentsList = service.showAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//Añadiendo lista a tabala Thymeleaf
		mav.addObject("students", studentsList);
		mav.setViewName("list");
		return mav;
	}
	
	
	@RequestMapping("/formEstudiante")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante student, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(!result.hasErrors()) {
			try {
				service.insertEs(student);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			student = new Estudiante();
			mav.addObject("student", student);
			
		}
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView borrar(@RequestParam(value="userId")int userId) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> studentsList = null;
		try {
			service.delete(userId);
			studentsList = service.showAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		mav.addObject("students", studentsList);
		mav.setViewName("list");
		return mav;
	}
}