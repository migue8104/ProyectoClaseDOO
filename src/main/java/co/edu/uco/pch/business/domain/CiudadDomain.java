package co.edu.uco.pch.business.domain;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;
import co.edu.uco.pch.crosscutting.helpers.UUIDHelper;

public class CiudadDomain {

	private UUID id;
	private String nombre;
	private DepartamentoDomain departamento;
	
	
	
	public CiudadDomain(UUID id, String nombre, DepartamentoDomain departamento) {
		setId (id);
		setNombre(nombre);
		setDepartamento(departamento);
	}
	
	public static CiudadDomain build(UUID id, String nombre, DepartamentoDomain departamento) {
		return new CiudadDomain(id, nombre, departamento);
	}
	
	public static CiudadDomain build(UUID id) {
		return new CiudadDomain(id,TextHelper.EMPTY,DepartamentoDomain.build());
	}
	
	public static CiudadDomain build() {
		return new CiudadDomain(UUIDHelper.getDefauld(),TextHelper.EMPTY, DepartamentoDomain.build());
	}
	
	private final void setId(UUID id) {
		this.id = id;
	}
	private final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private final void setDepartamento(DepartamentoDomain departamento) {
		this.departamento = departamento;
	}
	
	public final UUID getId() {
		return id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final DepartamentoDomain getDepartamento() {
		return departamento;
	}
	
	
	
}
