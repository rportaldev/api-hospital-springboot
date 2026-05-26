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

import com.example.demo.dto.PacienteDTO;
import com.example.demo.model.Paciente;
import com.example.demo.service.PacienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	
	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping
	public Paciente crearPaciente(@Valid @RequestBody PacienteDTO dto) {
		return pacienteService.crearPaciente(dto);
	}
	
	
	@GetMapping
	public List<Paciente> listarPacientes(){
		return pacienteService.listarPacientes();
	}
	
	
	@GetMapping("/{id}")
	public Paciente obtenerPorId(@PathVariable Long id) {
		return pacienteService.obtenerPacientePorId(id);
	}
	
	
	@PutMapping("/{id}")
	public Paciente actualizarPaciente(@PathVariable Long id, @RequestBody PacienteDTO dto) {
		return pacienteService.actualizarPaciente(id, dto.getNombre(), dto.getApellido(), dto.getEdad(), dto.getCorreo(), dto.getTelefono());
	}
	
	
	@DeleteMapping("/{id}")
	public boolean eliminarPaciente(@PathVariable Long id) {
		return pacienteService.eliminarPaciente(id);
	}
}
