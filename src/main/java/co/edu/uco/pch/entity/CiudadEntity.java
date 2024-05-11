package co.edu.uco.pch.entity;

import java.util.UUID;

import co.edu.uco.pch.crosscutting.helpers.TextHelper;

public final class CiudadEntity {
	private UUID id;
	private String nombre;
	private DepartamentoEntity Departamento;

	public CiudadEntity(){
		super();
	}
	
	public CiudadEntity(final UUID id,final  String nombre, final DepartamentoEntity departamento) {
		setId  (id);
		setNombre  (nombre);
		setDepartamento  (departamento);
	}
	
	public static final CiudadEntity build() {
		return new CiudadEntity();
	}
	public final UUID getId() {
		return id;
	}
	public final CiudadEntity setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final String getNombre() {
		return nombre;
	}
	public final  CiudadEntity  setNombre(final String nombre) {
		this.nombre = TextHelper.applyTrim(nombre);
		return this;
	}
	public final DepartamentoEntity getDepartamento() {
		return Departamento;
	}
	public final  CiudadEntity  setDepartamento(final DepartamentoEntity departamento) {
		Departamento = departamento;
		return this;
	}


}
