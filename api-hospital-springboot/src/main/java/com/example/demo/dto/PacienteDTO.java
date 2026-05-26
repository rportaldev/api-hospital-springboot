package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PacienteDTO {

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	
	@NotBlank(message = "El apellido es obligatorio")
	private String apellido;
	
	@Min(value = 0, message = "La edad no puede ser negativa")
	@Max(value = 120, message = "La edad no es válida")
	private int edad;
	
	
	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "El correo no es válido")
	private String correo;
	
	@NotBlank(message = "El telefono es obligatorio")
	@Size(min = 8, max = 20, message = "El teléfono debe tener entre 8 y 20 caracteres")
	private String telefono;

	public PacienteDTO(String nombre,String apellido,int edad, String correo,String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.correo = correo;
		this.telefono = telefono;
	}

	
	public PacienteDTO() {
		super();
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
}
