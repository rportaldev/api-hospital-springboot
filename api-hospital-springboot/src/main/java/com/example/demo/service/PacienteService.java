package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PacienteDTO;
import com.example.demo.model.Paciente;
import com.example.demo.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente crearPaciente(PacienteDTO dto) {
		
		Paciente paciente = new Paciente();
		
		paciente.setNombre(dto.getNombre());
		paciente.setApellido(dto.getApellido());
		paciente.setEdad(dto.getEdad());
		paciente.setCorreo(dto.getCorreo());
		paciente.setTelefono(dto.getTelefono());
		
		return pacienteRepository.save(paciente);
	}
	
	public List<Paciente> listarPacientes(){
		return pacienteRepository.findAll();
	}
	
	public Paciente obtenerPacientePorId(Long id) {
		
		return pacienteRepository.findById(id).orElse(null);
		
	}
	
	public Paciente actualizarPaciente(Long id, String nombre, String apellido, int edad, String correo, String telefono) {
		
		Paciente paciente = pacienteRepository.findById(id).orElse(null);
		
		if(paciente != null){
			
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setEdad(edad);
			paciente.setCorreo(correo);
			paciente.setTelefono(telefono);
			return pacienteRepository.save(paciente);
		}
		
		return null;
		
	}
	
	public boolean eliminarPaciente(Long id) {
		
		if(pacienteRepository.existsById(id)) {
			pacienteRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
	
}
