package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CitaDTO {

	@NotNull(message = "La fecha es obligatoria")
	private LocalDate fecha;
	
	@NotNull(message = "La hora es obligatoria")
	private LocalTime hora;
	
	@NotBlank(message = "El motivo es obligatorio")
	private String motivo;
	
	@NotBlank(message = "El estado es obligatorio")
	private String estado;
	
	private Long doctorId;
	
	private Long pacienteId;

	public CitaDTO(LocalDate fecha, LocalTime hora, String motivo, String estado, Long doctorId, Long pacienteId) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.motivo = motivo;
		this.estado = estado;
		this.doctorId = doctorId;
		this.pacienteId = pacienteId;
	}

	public CitaDTO() {
		super();
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPacienteId() {
		return pacienteId;
	}

	public void setPacienteId(Long pacienteId) {
		this.pacienteId = pacienteId;
	}
	
	
}
