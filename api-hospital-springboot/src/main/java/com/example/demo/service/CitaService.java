package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CitaDTO;
import com.example.demo.exception.RecursoNoEncontradoException;
import com.example.demo.model.Cita;
import com.example.demo.model.Doctor;
import com.example.demo.model.Paciente;
import com.example.demo.repository.CitaRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;

@Service
public class CitaService {

	@Autowired
	private CitaRepository citaRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Cita crearCita(CitaDTO dto) {
		
		Doctor doctor = doctorRepository.findById(dto.getDoctorId())
			    .orElseThrow(() -> new RecursoNoEncontradoException(
			        "Doctor no encontrado con ID: " + dto.getDoctorId()));
		
		Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
			    .orElseThrow(() -> new RecursoNoEncontradoException(
			        "Paciente no encontrado con ID: " + dto.getPacienteId()));
		
		Cita cita = new Cita();
		
		cita.setFecha(dto.getFecha());
		cita.setHora(dto.getHora());
		cita.setMotivo(dto.getMotivo());
		cita.setEstado(dto.getEstado());
		cita.setDoctor(doctor);
		cita.setPaciente(paciente);
		
		return citaRepository.save(cita);
	}
	
	
	
	public List<Cita> listarCitas(){
		return citaRepository.findAll();
	}
	
	
	
	public Cita obtenerCitaPorId(Long id) {
		
		return citaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Cita no encontrada con ID: " + id));
	}
	
	
	
	public Cita actualizarCita(Long id, LocalDate fecha, LocalTime hora, String motivo, 
								String estado, Long doctorId, Long pacienteId) {
		
		Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Doctor no encontrado con ID: " + doctorId));
		
	    Paciente paciente = pacienteRepository.findById(pacienteId).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Paciente no encontrado con ID: " + pacienteId));
	    
		Cita cita = citaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Doctor no encontrado con ID: " + id));
		
		
			cita.setFecha(fecha);
			cita.setHora(hora);
			cita.setMotivo(motivo);
			cita.setEstado(estado);
			cita.setDoctor(doctor);
			cita.setPaciente(paciente);
			
			return citaRepository.save(cita);
	}
	
	
	
	public boolean eliminarCita(Long id) {
		
		citaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException(
	            "Cita no encontrada con ID: " + id));
		
		
		citaRepository.deleteById(id);
		return true;
		
	}
	
	
	public List<Cita> filtarPorEstado(String estado){
		return citaRepository.findByEstado(estado);
	}
}
