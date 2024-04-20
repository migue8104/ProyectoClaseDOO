package co.edu.uco.pch.dto;

import java.util.UUID;

public final class CiudadDTO {
	private UUID id;
	private String nombre;
	private DepartamentoDTO Departamento;

	public CiudadDTO(){
		super();
	}
	
	public CiudadDTO(final UUID id,final  String nombre, final DepartamentoDTO departamento) {
		setId  (id);
		setNombre  (nombre);
		setDepartamento  (departamento);
	}
	
	public static final CiudadDTO build() {
		return new CiudadDTO();
	}
	public final UUID getId() {
		return id;
	}
	public final CiudadDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final  CiudadDTO  setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}
	public final DepartamentoDTO getDepartamento() {
		return Departamento;
	}
	public final  CiudadDTO  setDepartamento(final DepartamentoDTO departamento) {
		Departamento = departamento;
		return this;
	}


}
