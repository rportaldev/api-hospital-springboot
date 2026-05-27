package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CitaDTO;
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
		
		Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElse(null);
	    Paciente paciente = pacienteRepository.findById(dto.getPacienteId()).orElse(null);
		
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
		
		return citaRepository.findById(id).orElse(null);
	}
	
	
	
	public Cita actualizarCita(Long id, LocalDate fecha, LocalTime hora, String motivo, 
								String estado, Long doctorId, Long pacienteId) {
		
		Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
	    Paciente paciente = pacienteRepository.findById(pacienteId).orElse(null);
	    
		Cita cita = citaRepository.findById(id).orElse(null);
		
		if(cita != null) {
			cita.setFecha(fecha);
			cita.setHora(hora);
			cita.setMotivo(motivo);
			cita.setEstado(estado);
			cita.setDoctor(doctor);
			cita.setPaciente(paciente);
			
			return citaRepository.save(cita);
		}
		
		return null;
	}
	
	
	
	public boolean eliminarCita(Long id) {
		
		if(citaRepository.existsById(id)) {
			citaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	
	
	public List<Cita> filtarPorEstado(String estado){
		return citaRepository.findByEstado(estado);
	}
}
