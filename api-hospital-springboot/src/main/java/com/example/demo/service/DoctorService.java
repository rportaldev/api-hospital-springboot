package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DoctorDTO;
import com.example.demo.exception.RecursoNoEncontradoException;
import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	
	public Doctor crearDoctor(DoctorDTO dto) {
		
		Doctor doctor = new Doctor();
		
		doctor.setNombre(dto.getNombre());
		doctor.setEspecialidad(dto.getEspecialidad());
		doctor.setCorreo(dto.getCorreo());
		doctor.setTelefono(dto.getTelefono());
		
		return doctorRepository.save(doctor);
	}
	
	
	public List<Doctor> listarDoctores(){
		return doctorRepository.findAll();
	}
	
	
	public Doctor obtenerPorId(Long id) {
		
		return doctorRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Doctor no encontrado con ID: " + id));
	}
	
	
	public Doctor actualizarDoctor(Long id, String nombre, String especialidad, String correo, String telefono) {
		
		Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Doctor no encontrado con ID: " + id));;
		
		
			doctor.setNombre(nombre);
			doctor.setEspecialidad(especialidad);
			doctor.setCorreo(correo);
			doctor.setTelefono(telefono);
			
			return doctorRepository.save(doctor);
		
	}
	
	
	public boolean eliminarDoctor(Long id) {
		
		doctorRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Doctor no encontrado con ID: " + id)); 
		
		doctorRepository.deleteById(id);
		return true;
		
	}
	 
}
