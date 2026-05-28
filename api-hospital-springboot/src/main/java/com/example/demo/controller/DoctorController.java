package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.model.Cita;
import com.example.demo.model.Doctor;
import com.example.demo.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctores")
public class DoctorController {


	@Autowired
	private DoctorService doctorService;

    
	@PostMapping
	public Doctor crearDoctor(@Valid @RequestBody DoctorDTO dto) {
		return doctorService.crearDoctor(dto);
	}
	
	
	@GetMapping
	public List<Doctor> listarDoctores(){
		return doctorService.listarDoctores();
	}
	
	
	@GetMapping("/{id}")
	public Doctor obtenerDoctorPorId(@PathVariable Long id) {
		return doctorService.obtenerPorId(id);
	}
	
	
	@PutMapping("/{id}")
	public Doctor actualizarDoctor(@PathVariable Long id, @RequestBody DoctorDTO dto) {
		return doctorService.actualizarDoctor(id, dto.getNombre(), dto.getEspecialidad(), dto.getCorreo(), dto.getTelefono());
	}
	
	
	@DeleteMapping("/{id}")
	public boolean eliminarDoctor(@PathVariable Long id) {
		return doctorService.eliminarDoctor(id);
	}
	
	@GetMapping("/{id}/citas")
	public List<Cita> listarCitasDeDoctor(@PathVariable Long id) {
	    return doctorService.listarCitasDeDoctor(id);
	}
	
}
