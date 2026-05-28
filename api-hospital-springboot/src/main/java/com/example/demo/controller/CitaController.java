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

import com.example.demo.dto.CitaDTO;
import com.example.demo.model.Cita;
import com.example.demo.service.CitaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/citas")
public class CitaController {

	@Autowired
	private CitaService citaService;
	

	@PostMapping
	public Cita crearCita(@Valid @RequestBody CitaDTO dto) {
		return citaService.crearCita(dto);
	}
	
	
	@GetMapping
	public List<Cita> listarCitas(){
		return citaService.listarCitas();
	}
	
	
	@GetMapping("/{id}")
	public Cita obtenerPorId(@PathVariable Long id) {
		return citaService.obtenerCitaPorId(id);
	}
	
	
	@PutMapping("/{id}")
	public Cita actualizarCita(@PathVariable Long id, @RequestBody CitaDTO dto) {
		return citaService.actualizarCita(id, dto.getFecha(), dto.getHora(), dto.getMotivo(), dto.getEstado(),dto.getDoctorId(),dto.getPacienteId());
	}
	
	
	@DeleteMapping("/{id}")
	public boolean eliminarCita(@PathVariable Long id) {
		return citaService.eliminarCita(id);
	}
	
	@GetMapping("/estado/{estado}")
	public List<Cita> filtarPorEstado(@PathVariable String estado){
		return citaService.filtarPorEstado(estado);
	}
}
